package cn.hospital.registerplatform.ui.component.comment

import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import cn.hospital.registerplatform.data.dto.SingleComment
import cn.hospital.registerplatform.data.dto.UploadComment
import cn.hospital.registerplatform.data.repository.CommentRepository
import cn.hospital.registerplatform.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(private val repository: CommentRepository) :
    BaseViewModel() {
    fun getCommentList(hospitalId: Int): Flow<PagingData<SingleComment>> {
        return repository.getComment(hospitalId)
    }

    fun submitComment(
        hospitalId: Int,
        uploadComment: UploadComment
    ) = repository.createComment(hospitalId, uploadComment).asLiveData()

}