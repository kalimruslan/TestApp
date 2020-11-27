package ru.androidrt.test.presentation.picture

import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_picture.imageViewPicture
import kotlinx.android.synthetic.main.fragment_picture.textViewUrl
import ru.androidrt.test.R
import ru.androidrt.test.presentation.base.BaseFragment

class PictureDetailFragment : BaseFragment(R.layout.fragment_picture) {

    private val args: PictureDetailFragmentArgs by navArgs()
    private val detailViewModel: PictureDetailViewModel by appViewModels()

    override fun onLayoutSetup() {
        textViewUrl.text = args.picture.largeImageURL
    }

    override fun onBindViewModel() = with(detailViewModel){
        bitmapDownloadedLiveData.observe {
            imageViewPicture.setImageBitmap(it)
        }
    }

    override fun callOperations() {
        detailViewModel.downloadPicture(args.picture.largeImageURL)
    }
}