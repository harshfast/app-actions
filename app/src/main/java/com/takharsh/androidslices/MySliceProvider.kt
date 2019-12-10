package com.takharsh.androidslices

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.builders.*


class MySliceProvider : androidx.slice.SliceProvider() {

    override fun onCreateSliceProvider(): Boolean {
        return true;
    }

    override fun onBindSlice(sliceUri: Uri?): Slice {
        val activityAction = createActivityAction()

        val sliceUriNotNull: Uri = sliceUri as Uri
        return if (sliceUriNotNull?.path == "/hello") {
            list(context, sliceUriNotNull, ListBuilder.INFINITY) {
                //                row {
//                    primaryAction = activityAction
//                    title = "Hello World."
//                }

                header {
                    title = "CabOne"
                    subtitle = "We have found 3 services nearby"
                    summary = ""
                }
                row {
                    title = "Mini"
                    subtitle = "15 miles | 20 mins | $15.23"
                    primaryAction =
                        activityAction//createActivityAction(Intent(context, MainActivity::class.java), R.drawable.ic_launcher_background, SliceHints.ICON_IMAGE)
                }
                row {
                    title = "Sedan"
                    subtitle = "15 miles | 25 mins | $24.90"
                    primaryAction = activityAction
                }
                row {
                    title = "Prime"
                    subtitle = "15 miles | 20 mins | $56.90"
                    primaryAction = activityAction
                }


            }
        } else {
            list(context, sliceUriNotNull, ListBuilder.INFINITY) {
                row {
                    primaryAction = activityAction
                    title = "URI not recognized."
                }
            }
        }
    }

    fun createActivityAction(): SliceAction {
        val intent = Intent(context, MainActivity::class.java)
        return SliceAction.create(
            PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0),
            IconCompat.createWithResource(context, R.drawable.ic_launcher_foreground),
            ListBuilder.ICON_IMAGE,
            "Enter app"
        )
    }


}