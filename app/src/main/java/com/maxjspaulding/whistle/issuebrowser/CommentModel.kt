package com.maxjspaulding.whistle.issuebrowser

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.maxjspaulding.whistle.issuebrowser.api.data.Comment


/**
 * This class needs to be abstract as Epoxy inherits this class to form SingleIssueModel_() class.
 * @see https://github.com/airbnb/epoxy/wiki/Epoxy-Models
 */
@EpoxyModelClass(layout = R.layout.comment_card)
abstract class CommentModel (@EpoxyAttribute var comment: Comment) : EpoxyModelWithHolder<CommentModel.CommentHolder>(){

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: ((View) -> Unit)? = null

    override fun bind(holder: CommentHolder) {

        holder.commentView.text = comment.body
        holder.authorView.text = comment.user.login

        holder.cardView.setOnClickListener(clickListener)
    }

    /**
     * This is ViewHolder class equivalent to Google's RecyclerView.ViewHolder class
     */
    inner class CommentHolder : KotlinHolder(){

        val cardView by bind<CardView>(R.id.cv_issue)
        val commentView by bind<TextView>(R.id.comment_body)
        val authorView by bind<TextView>(R.id.comment_author)

    }

}
