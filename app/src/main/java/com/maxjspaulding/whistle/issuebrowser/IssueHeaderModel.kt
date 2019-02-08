package com.maxjspaulding.whistle.issuebrowser

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.maxjspaulding.whistle.issuebrowser.api.data.Issue


/**
 * This class needs to be abstract as Epoxy inherits this class to form SingleIssueModel_() class.
 * @see https://github.com/airbnb/epoxy/wiki/Epoxy-Models
 */
@EpoxyModelClass(layout = R.layout.view_issue_title)
abstract class IssueHeaderModel (@EpoxyAttribute var issue: Issue) : EpoxyModelWithHolder<IssueHeaderModel.IssueHolder>(){

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: ((View) -> Unit)? = null

    override fun bind(holder: IssueHolder) {
        holder.titleView.text = issue.title
        holder.cardView.setOnClickListener(clickListener)
    }

    /**
     * This is ViewHolder class equivalent to Google's RecyclerView.ViewHolder class
     */
    inner class IssueHolder : KotlinHolder(){
        val cardView by bind<CardView>(R.id.cv_issue)
        val titleView by bind<TextView>(R.id.text_view_issue_title)
    }

}


