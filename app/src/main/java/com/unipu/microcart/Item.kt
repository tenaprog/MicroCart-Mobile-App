package com.unipu.microcart

class Item(
    val name: String,
    val description: String,
    val image: Int,
    val availableSizes: Array<String>,
    val price: Double
)

fun getItemDescription(): String {
    return "This versatile and stylish item is perfect for everyday use. Designed with both functionality and aesthetics in mind, it seamlessly blends quality with practicality. Made from premium materials, it ensures durability and reliability for all your needs. Whether you're heading to work, attending an event, or simply relaxing at home, this item complements any occasion. Its sleek design and attention to detail make it an excellent addition to any collection. With its user-friendly features and modern appeal, this item delivers both comfort and convenience. Upgrade your lifestyle with this essential, timeless piece."
}

fun getItemList(): List<Item> {
    return listOf(
        Item(
            "Classic T-Shirt",
            getItemDescription(),
            R.drawable.tshirt,
            arrayOf("S", "M", "L", "XL"),
            12.99
        ),
        Item(
            "Slim Fit Jeans",
            getItemDescription(),
            R.drawable.jeans,
            arrayOf("28", "30", "32", "34", "36"),
            49.99
        ),
        Item(
            "Insulated Jacket",
            getItemDescription(),
            R.drawable.jacket,
            arrayOf("M", "L", "XL"),
            99.99
        ),
        Item(
            "Running Sneakers",
            getItemDescription(),
            R.drawable.sneakers,
            arrayOf("7", "8", "9", "10", "11"),
            64.99
        ),
        Item(
            "Winter Hat",
            getItemDescription(),
            R.drawable.hat,
            arrayOf("One Size"),
            18.50
        ),
        Item(
            "Cotton Socks",
            getItemDescription(),
            R.drawable.socks,
            arrayOf("M", "L"),
            9.99
        ),
        Item(
            "Digital Watch",
            getItemDescription(),
            R.drawable.watch,
            arrayOf("One Size"),
            119.99
        ),
        Item(
            "Cotton T-Shirt",
            getItemDescription(),
            R.drawable.tshirt,
            arrayOf("S", "M", "L", "XL"),
            15.99
        ),
        Item(
            "Skinny Jeans",
            getItemDescription(),
            R.drawable.jeans,
            arrayOf("28", "30", "32", "34", "36"),
            54.99
        ),
        Item(
            "Windbreaker Jacket",
            getItemDescription(),
            R.drawable.jacket,
            arrayOf("M", "L", "XL"),
            79.99
        ),
        Item(
            "Sports Sneakers",
            getItemDescription(),
            R.drawable.sneakers,
            arrayOf("7", "8", "9", "10", "11"),
            74.99
        ),
        Item(
            "Foldable Hat",
            getItemDescription(),
            R.drawable.hat,
            arrayOf("One Size"),
            20.00
        ),
        Item(
            "Thermal Socks",
            getItemDescription(),
            R.drawable.socks,
            arrayOf("M", "L"),
            12.99
        ),
        Item(
            "Luxury Watch",
            getItemDescription(),
            R.drawable.watch,
            arrayOf("One Size"),
            199.99
        ),
        Item(
            "T-shirt Style",
            getItemDescription(),
            R.drawable.tshirt,
            arrayOf("S", "M", "L", "XL"),
            10.99
        ),
        Item(
            "Jeans Stylish",
            getItemDescription(),
            R.drawable.jeans,
            arrayOf("28", "30", "32", "34", "36"),
            45.50
        ),
        Item(
            "Jacket Warm",
            getItemDescription(),
            R.drawable.jacket,
            arrayOf("M", "L", "XL"),
            89.99
        ),
        Item(
            "Sneakers Trend",
            getItemDescription(),
            R.drawable.sneakers,
            arrayOf("7", "8", "9", "10", "11"),
            59.99
        ),
        Item(
            "Hat Stylish",
            getItemDescription(),
            R.drawable.hat,
            arrayOf("One Size"),
            15.00
        ),
        Item(
            "Socks Soft",
            getItemDescription(),
            R.drawable.socks,
            arrayOf("M", "L"),
            8.99
        ),
        Item(
            "Watch Digital",
            getItemDescription(),
            R.drawable.watch,
            arrayOf("One Size"),
            99.99
        ),
        Item(
            "T-shirt Cotton",
            getItemDescription(),
            R.drawable.tshirt,
            arrayOf("S", "M", "L", "XL"),
            10.99
        ),
        Item(
            "Jeans Denim",
            getItemDescription(),
            R.drawable.jeans,
            arrayOf("28", "30", "32", "34", "36"),
            45.50
        ),
        Item(
            "Jacket Cozy",
            getItemDescription(),
            R.drawable.jacket,
            arrayOf("M", "L", "XL"),
            89.99
        ),
        Item(
            "Sneakers White",
            getItemDescription(),
            R.drawable.sneakers,
            arrayOf("7", "8", "9", "10", "11"),
            59.99
        ),
        Item(
            "Hat Summer",
            getItemDescription(),
            R.drawable.hat,
            arrayOf("One Size"),
            15.00
        ),
        Item(
            "Socks Cotton",
            getItemDescription(),
            R.drawable.socks,
            arrayOf("M", "L"),
            8.99
        ),
        Item(
            "Wristwatch",
            getItemDescription(),
            R.drawable.watch,
            arrayOf("One Size"),
            99.99
        ),
        Item(
            "T-shirt White",
            getItemDescription(),
            R.drawable.tshirt,
            arrayOf("S", "M", "L", "XL"),
            10.99
        ),
        Item(
            "Jeans Blue",
            getItemDescription(),
            R.drawable.jeans,
            arrayOf("28", "30", "32", "34", "36"),
            45.50
        ),
        Item(
            "Jacket Winter",
            getItemDescription(),
            R.drawable.jacket,
            arrayOf("M", "L", "XL"),
            89.99
        ),
        Item(
            "Sneakers Sport",
            getItemDescription(),
            R.drawable.sneakers,
            arrayOf("7", "8", "9", "10", "11"),
            59.99
        )
    )
}
