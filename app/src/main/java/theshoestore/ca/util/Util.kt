package theshoestore.ca.util

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import theshoestore.ca.R
import theshoestore.ca.model.Shoes
import kotlin.random.Random

object Util {
    fun getListOfShoes(): MutableList<Shoes> {
        return mutableListOf(
            Shoes(
                1,
                "New Balance M990v5",
                "12 mm drop: due to variances created during the development and manufacturing processes, all references to 12 mm drop are approximate\n" +
                        "Blown rubber outsole\n" +
                        "ENCAP® midsole technology provides support and maximum durability\n" +
                        "Manufactured in the US for over 75 years and representing a limited portion of our US sales. New Balance Made is a premium collection that contains a domestic value of 70% or greater.\n" +
                        "Pigskin/mesh upper\n" +
                        "Dual Density Collar Foam\n" +
                        "ENCAP PU Ring with EVA Core",
                    "$229.99",
                R.drawable.shoes_m990v5
            ),
            Shoes(
                2,
                "New Balance ML574v2",
                "Adjustable lace closure for a customized fit\n" +
                        "Available in a range of colors to suit your style preferences\n" +
                        "ENCAP midsole cushioning combines lightweight foam with a durable polyurethane rim to deliver all-day support\n" +
                        "Lightweight EVA foam cushioning in the midsole and heel increases comfort\n" +
                        "New Balance N logo branding\n" +
                        "Retro style details for a fashionable look\n" +
                        "Rubber outsole\n" +
                        "Suede and mesh upper for a comfortable fit and feel",
                    "$109.99",
                R.drawable.shoes_ml574v2
            ),
            Shoes(
                3,
                "New Balance M1080v10",
                "8 mm drop; due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                        "Blown rubber outsole provides superior rebound\n" +
                        "Bootie upper construction hugs your foot for a snug, supportive fit\n" +
                        "Engineered knit synthetic/mesh material\n" +
                        "Fresh Foam midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                        "Hypoknit upper designed to provide strategic areas of stretch and support\n" +
                        "Ortholite cushion insert designed for unmatched comfort and significant moisture control to combat sweat\n" +
                        "Ultra Heel design hugs the back of the foot for a snug, supportive fit",
                    "$209.99",
                R.drawable.shoes_m1080v10
            ),
            Shoes(
                4,
                "New Balance MROAVv1",
                    "8 mm drop: Due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                            "Bootie upper construction hugs your foot for a snug, supportive fit\n" +
                            "FRESH FOAM midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                            "Mesh/synthetic upper\n" +
                            "Ultra Heel design hugs the back of the foot for a snug, supportive fit",
                "$109.99",
                R.drawable.shoes_mroavv1
            ),
            Shoes(
                5,
                "New Balance MLC100v1",
                    "Classic N logo branding\n" +
                            "Durable rubber outsole\n" +
                            "Lace-up closure for a secure fit\n" +
                            "Leather upper for comfort and style",
                "$89.00",
                R.drawable.shoes_mlc100v1
            ),
            Shoes(
                6,
                "New Balance BBOMNLv1",
                    "FitWeave holds its shape for a long-lasting, locked-in fit\n" +
                            "FuelCell foam delivers a propulsive feel to help drive you forward\n" +
                            "Low cut\n" +
                            "Ultra heel design hugs the back of the foot for a snug, supportive fit",
                "$49.00",
                R.drawable.shoes_bbomnlv1
            ),
                Shoes(
                        7,
                        "New Balance M990v5",
                        "12 mm drop: due to variances created during the development and manufacturing processes, all references to 12 mm drop are approximate\n" +
                                "Blown rubber outsole\n" +
                                "ENCAP® midsole technology provides support and maximum durability\n" +
                                "Manufactured in the US for over 75 years and representing a limited portion of our US sales. New Balance Made is a premium collection that contains a domestic value of 70% or greater.\n" +
                                "Pigskin/mesh upper\n" +
                                "Dual Density Collar Foam\n" +
                                "ENCAP PU Ring with EVA Core",
                        "$229.99",
                        R.drawable.shoes_m990v5
                ),
                Shoes(
                        8,
                        "New Balance ML574v2",
                        "Adjustable lace closure for a customized fit\n" +
                                "Available in a range of colors to suit your style preferences\n" +
                                "ENCAP midsole cushioning combines lightweight foam with a durable polyurethane rim to deliver all-day support\n" +
                                "Lightweight EVA foam cushioning in the midsole and heel increases comfort\n" +
                                "New Balance N logo branding\n" +
                                "Retro style details for a fashionable look\n" +
                                "Rubber outsole\n" +
                                "Suede and mesh upper for a comfortable fit and feel",
                        "$109.99",
                        R.drawable.shoes_ml574v2
                ),
                Shoes(
                        9,
                        "New Balance M1080v10",
                        "8 mm drop; due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                                "Blown rubber outsole provides superior rebound\n" +
                                "Bootie upper construction hugs your foot for a snug, supportive fit\n" +
                                "Engineered knit synthetic/mesh material\n" +
                                "Fresh Foam midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                                "Hypoknit upper designed to provide strategic areas of stretch and support\n" +
                                "Ortholite cushion insert designed for unmatched comfort and significant moisture control to combat sweat\n" +
                                "Ultra Heel design hugs the back of the foot for a snug, supportive fit",
                        "$209.99",
                        R.drawable.shoes_m1080v10
                ),
                Shoes(
                        10,
                        "New Balance MROAVv1",
                        "8 mm drop: Due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                                "Bootie upper construction hugs your foot for a snug, supportive fit\n" +
                                "FRESH FOAM midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                                "Mesh/synthetic upper\n" +
                                "Ultra Heel design hugs the back of the foot for a snug, supportive fit",
                        "$109.99",
                        R.drawable.shoes_mroavv1
                ),
                Shoes(
                        11,
                        "New Balance MLC100v1",
                        "Classic N logo branding\n" +
                                "Durable rubber outsole\n" +
                                "Lace-up closure for a secure fit\n" +
                                "Leather upper for comfort and style",
                        "$89.00",
                        R.drawable.shoes_mlc100v1
                ),
                Shoes(
                        12,
                        "New Balance BBOMNLv1",
                        "FitWeave holds its shape for a long-lasting, locked-in fit\n" +
                                "FuelCell foam delivers a propulsive feel to help drive you forward\n" +
                                "Low cut\n" +
                                "Ultra heel design hugs the back of the foot for a snug, supportive fit",
                        "$49.00",
                        R.drawable.shoes_bbomnlv1
                ),
                Shoes(
                        13,
                        "New Balance M990v5",
                        "12 mm drop: due to variances created during the development and manufacturing processes, all references to 12 mm drop are approximate\n" +
                                "Blown rubber outsole\n" +
                                "ENCAP® midsole technology provides support and maximum durability\n" +
                                "Manufactured in the US for over 75 years and representing a limited portion of our US sales. New Balance Made is a premium collection that contains a domestic value of 70% or greater.\n" +
                                "Pigskin/mesh upper\n" +
                                "Dual Density Collar Foam\n" +
                                "ENCAP PU Ring with EVA Core",
                        "$229.99",
                        R.drawable.shoes_m990v5
                ),
                Shoes(
                        14,
                        "New Balance ML574v2",
                        "Adjustable lace closure for a customized fit\n" +
                                "Available in a range of colors to suit your style preferences\n" +
                                "ENCAP midsole cushioning combines lightweight foam with a durable polyurethane rim to deliver all-day support\n" +
                                "Lightweight EVA foam cushioning in the midsole and heel increases comfort\n" +
                                "New Balance N logo branding\n" +
                                "Retro style details for a fashionable look\n" +
                                "Rubber outsole\n" +
                                "Suede and mesh upper for a comfortable fit and feel",
                        "$109.99",
                        R.drawable.shoes_ml574v2
                ),
                Shoes(
                        15,
                        "New Balance M1080v10",
                        "8 mm drop; due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                                "Blown rubber outsole provides superior rebound\n" +
                                "Bootie upper construction hugs your foot for a snug, supportive fit\n" +
                                "Engineered knit synthetic/mesh material\n" +
                                "Fresh Foam midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                                "Hypoknit upper designed to provide strategic areas of stretch and support\n" +
                                "Ortholite cushion insert designed for unmatched comfort and significant moisture control to combat sweat\n" +
                                "Ultra Heel design hugs the back of the foot for a snug, supportive fit",
                        "$209.99",
                        R.drawable.shoes_m1080v10
                ),
                Shoes(
                        16,
                        "New Balance MROAVv1",
                        "8 mm drop: Due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                                "Bootie upper construction hugs your foot for a snug, supportive fit\n" +
                                "FRESH FOAM midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                                "Mesh/synthetic upper\n" +
                                "Ultra Heel design hugs the back of the foot for a snug, supportive fit",
                        "$109.99",
                        R.drawable.shoes_mroavv1
                ),
                Shoes(
                        17,
                        "New Balance MLC100v1",
                        "Classic N logo branding\n" +
                                "Durable rubber outsole\n" +
                                "Lace-up closure for a secure fit\n" +
                                "Leather upper for comfort and style",
                        "$89.00",
                        R.drawable.shoes_mlc100v1
                ),
                Shoes(
                        18,
                        "New Balance BBOMNLv1",
                        "FitWeave holds its shape for a long-lasting, locked-in fit\n" +
                                "FuelCell foam delivers a propulsive feel to help drive you forward\n" +
                                "Low cut\n" +
                                "Ultra heel design hugs the back of the foot for a snug, supportive fit",
                        "$49.00",
                        R.drawable.shoes_bbomnlv1
                ),
        )
    }

    fun getImage(): Int{
        return when ((1..5).random()) {
            1 -> R.drawable.shoe01
            2 -> R.drawable.shoe02
            3 -> R.drawable.shoe03
            4 -> R.drawable.shoe04
            else -> R.drawable.shoe05
        }
    }

    fun cancelInsertOrEdition(context: Context, navController: NavController) {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogTheme)

        builder.setMessage(context.getString(R.string.msg_cancel_operation))
                .setTitle(context.getString(R.string.app_name))
                .setCancelable(false)
                .setPositiveButton(context.getString(R.string.dialog_positive)) { view, _ ->
                    navController.navigate(R.id.listFragment)
                }
                .setNegativeButton(context.getString(R.string.dialog_negative)) { _, _ -> }

        val dialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val layParams = dialog.window!!.attributes
        layParams.gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
        dialog.window!!.attributes = layParams
        dialog.show()
    }
}