package com.unipu.microcart

class Item(
    val name: String,
    val description: String,
    val image: Int,
    val availableSizes: Array<String>,
    val price: Double
)

fun getItemList(): List<Item> {
    return listOf(
        Item("T-shirt 1", "Comfortable cotton T-shirt", R.drawable.tshirt, arrayOf("S", "M", "L", "XL"), 10.99),
        Item("Jeans 1", "Stylish denim jeans", R.drawable.jeans, arrayOf("28", "30", "32", "34", "36"), 45.50),
        Item("Jacket 1", "Warm and cozy jacket", R.drawable.jacket, arrayOf("M", "L", "XL"), 89.99),
        Item("Sneakers 1", "Trendy sneakers", R.drawable.sneakers, arrayOf("7", "8", "9", "10", "11"), 59.99),
        Item("Hat 1", "Stylish summer hat", R.drawable.hat, arrayOf("One Size"), 15.00),
        Item("Socks 1", "Soft cotton socks (pack of 3)", R.drawable.socks, arrayOf("M", "L"), 8.99),
        Item("Watch 1", "Digital wristwatch", R.drawable.watch, arrayOf("One Size"), 99.99),
        Item("T-shirt 2", "Comfortable cotton T-shirt", R.drawable.tshirt, arrayOf("S", "M", "L", "XL"), 10.99),
        Item("Jeans 2", "Stylish denim jeans", R.drawable.jeans, arrayOf("28", "30", "32", "34", "36"), 45.50),
        Item("Jacket 2", "Warm and cozy jacket", R.drawable.jacket, arrayOf("M", "L", "XL"), 89.99),
        Item("Sneakers 2", "Trendy sneakers", R.drawable.sneakers, arrayOf("7", "8", "9", "10", "11"), 59.99),
        Item("Hat 2", "Stylish summer hat", R.drawable.hat, arrayOf("One Size"), 15.00),
        Item("Socks 2", "Soft cotton socks (pack of 3)", R.drawable.socks, arrayOf("M", "L"), 8.99),
        Item("Watch 2", "Digital wristwatch", R.drawable.watch, arrayOf("One Size"), 99.99),
        Item("T-shirt 3", "Comfortable cotton T-shirt", R.drawable.tshirt, arrayOf("S", "M", "L", "XL"), 10.99),
        Item("Jeans 3", "Stylish denim jeans", R.drawable.jeans, arrayOf("28", "30", "32", "34", "36"), 45.50),
        Item("Jacket 3", "Warm and cozy jacket", R.drawable.jacket, arrayOf("M", "L", "XL"), 89.99),
        Item("Sneakers 3", "Trendy sneakers", R.drawable.sneakers, arrayOf("7", "8", "9", "10", "11"), 59.99),
        Item("Hat 3", "Stylish summer hat", R.drawable.hat, arrayOf("One Size"), 15.00),
        Item("Socks 3", "Soft cotton socks (pack of 3)", R.drawable.socks, arrayOf("M", "L"), 8.99),
        Item("Watch 3", "Digital wristwatch", R.drawable.watch, arrayOf("One Size"), 99.99)
    )
}
