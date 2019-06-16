package com.afghazy.framework.mvvm.data.model.others

import android.os.Parcelable
import com.afghazy.framework.mvvm.data.model.db.Option
import com.afghazy.framework.mvvm.data.model.db.Question
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuestionCardData(val showCorrectOptions: Boolean,
                            val options: List<Option>,
                            val question: Question) : Parcelable