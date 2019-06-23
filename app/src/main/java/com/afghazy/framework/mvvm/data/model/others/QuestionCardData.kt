package com.afghazy.framework.mvvm.data.model.others

import android.os.Parcelable
import com.afghazy.framework.mvvm.data.model.local.Option
import com.afghazy.framework.mvvm.data.model.local.Question
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuestionCardData(val showCorrectOptions: Boolean,
                            val options: List<Option>,
                            val question: Question) : Parcelable