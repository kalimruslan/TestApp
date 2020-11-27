package ru.androidrt.test.presentation.pictures

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_pictures.progressBar
import kotlinx.android.synthetic.main.fragment_pictures.recyclerViewPictures
import ru.androidrt.test.R
import ru.androidrt.test.data.LoadableResult
import ru.androidrt.test.presentation.base.BaseFragment
import javax.inject.Inject

class PicturesFragment : BaseFragment(R.layout.fragment_pictures) {

    private val viewModel: PicturesViewModel by appViewModels()
    @Inject lateinit var picturesAdapter: PicturesAdapter

    override fun onLayoutSetup() {
        picturesAdapter.lifecycleCoroutineScope = lifecycleScope
        recyclerViewPictures.adapter = picturesAdapter
        picturesAdapter.onPictureClick = { picture ->
            findNavController().navigate(PicturesFragmentDirections.actionPicturesFragmentToPictureFragment(picture))
        }
    }

    override fun onBindViewModel() = with(viewModel) {
        allPicturesLiveData.observe { result ->
            when (result) {
                is LoadableResult.Loading -> {
                    progressBar.isVisible = true
                }
                is LoadableResult.Success -> {
                    progressBar.isVisible = false
                    picturesAdapter.submitList(result.value)
                }
                is LoadableResult.Failure -> {
                    progressBar.isVisible = false
                }
            }
        }
    }

    override fun callOperations() {
        viewModel.getPicturesData()
    }
}