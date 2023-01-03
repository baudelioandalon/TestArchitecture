package com.boreal.allen.home.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import com.boreal.allen.core.MODEL_PROFILE
import com.boreal.allen.core.domain.StatusRequestEnum
import com.boreal.allen.core.domain.entity.UserModel
import com.boreal.allen.core.domain.entity.profile.ProfileArguments
import com.boreal.allen.home.R
import com.boreal.allen.home.databinding.HomeFragmentBinding
import com.boreal.allen.home.databinding.ItemUserBinding
import com.boreal.allen.home.viewmodel.HomeViewModel
import com.boreal.commonutils.base.CUBaseFragment
import com.boreal.commonutils.extensions.hideView
import com.boreal.commonutils.extensions.onClick
import com.boreal.commonutils.extensions.showToast
import com.boreal.commonutils.extensions.showView
import com.boreal.commonutils.utils.GAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.boreal.allen.profile.R as profileR
import com.boreal.allen.uisystem.R as uiSystemR

class HomeFragment : CUBaseFragment<HomeFragmentBinding>() {

    val viewModel: HomeViewModel by viewModel()

    val adapterRecyclerUsers by lazy {
        GAdapter<ItemUserBinding, UserModel>(
            R.layout.item_user,
            AsyncDifferConfig.Builder(object : DiffUtil.ItemCallback<UserModel>() {
                override fun areItemsTheSame(
                    oldItem: UserModel,
                    newItem: UserModel
                ) = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: UserModel,
                    newItem: UserModel
                ) = oldItem == newItem

            }).build(),
            holderCallback = { bindingElement, model, _, _, _ ->
                bindingElement.userProfile =
                    model.picture.large ?: model.picture.medium ?: model.picture.thumbnail
                bindingElement.apply {
                    tvLocation.text = model.nat.orEmpty()
                    tvName.text = getString(
                        uiSystemR.string.name_holder,
                        model.name?.first.orEmpty(),
                        model.name?.last.orEmpty()
                    )
                    tvLastname.text = model.name?.title.orEmpty()
                    containerUserItem.onClick {
                        findNavController().navigate(
                            resId = profileR.id.profile_graph,
                            args = bundleOf(MODEL_PROFILE to ProfileArguments(profileModel = model))
                        )
                    }
                }
            }
        )
    }

    override fun getLayout() = R.layout.home_fragment

    override fun initView() {
        initElements()
    }

    override fun initObservers() {
        viewModel.usersList.observe(viewLifecycleOwner) {
            it?.let {
                when (it.status) {
                    StatusRequestEnum.LOADING -> {
                        showProgress()
                        binding.btnRetry.hideView()
                    }
                    StatusRequestEnum.SUCCESS, StatusRequestEnum.FAILURE -> {
                        hideProgressBarCustom()
                        it.failure?.let { errorResult ->
                            showToast(errorResult)
                            binding.apply {
                                btnRetry.showView()
                                btnRetry.onClick {
                                    viewModel.requestGetUsers()
                                }
                                recyclerUsers.hideView()
                            }
                            return@observe
                        }
                        binding.btnRetry.hideView()
                        binding.recyclerUsers.showView()
                        loadRecyclerUsers(it.response?.results ?: emptyList())
                    }
                    else -> {}
                }
            }
        }
    }
}