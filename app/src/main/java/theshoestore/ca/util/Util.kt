package theshoestore.ca.util

import theshoestore.ca.R
import theshoestore.ca.model.Shoes
import kotlin.random.Random

object Util {
    fun getListOfShoes(): MutableList<Shoes> {
        return mutableListOf(
            Shoes(
                1,
                "New Balance 696v4",
                "THE HISTORY AND EVOLUTION OF SHOES\n" +
                        "It’s hard to imagine what life was like when shoes weren’t discovered yet. \n" +
                        "Everything started because of a real and practical need to protect the feet from outside effects. \n" +
                        "This seemingly simple human need turned into a quickly growing industry in which design was just as important \n" +
                        "as functionality. Although the main qualities of footwear have remained unchanged, looking back at the long \n" +
                        "and interesting history of shoes, you can see that the colors, materials and designs did change. \n" +
                        "Before, shoes used to be made by craftsmen. But today, they are part of a factory industry earning \n" +
                        "huge amounts of money each year.\n" +
                        "The history, changes and tendencies in footwear fashion can be divided into the main world history\n" +
                        "During different eras there were different views of the world, different understandings of culture and art, " +
                        "different economic and political factors which played an important role in the materials, shapes, pronts, " +
                        "and style used in people’s wardrobe. The discovery and capture of new lands, new technologies and different " +
                        "understandings of the world changed the style and fashion of footwear.\n" +
                        "Primitive footwear, popular during Prehistory, was changed by sandals which grew in popularity during " +
                        "Antiquity because of the formation of social classes. During the Middle Ages, which are characterized by " +
                        "humility and feudalism, the first footwear structures were formed and the heel was discovered and widely used. " +
                        "During the Early Modern Times were the eras of Renaissance and Baroque during which hints of modern footwear " +
                        "can be spotted. During this time, men’s and women’s shoes were very similar. The models of shoes varied depending " +
                        "on social classes. Also, during the Middle Ages when feudalism was present, society was divided into classes " +
                        "deciding not only different jobs and responsibilities but also different clothes and footwear. Peasants and " +
                        "non-noble townspeople wore heavy and dark leather boots with a heel. Meanwhile, the noble wore more fancy " +
                        "footwear which often had a wooden heel.  Prints, ornaments and other decorative elements were worn only by " +
                        "the noble. They would order these shoes from a shoemaker. Every shoe was different and decorated according " +
                        "to the mood and wishes of the customer, so every single pair of shoes was unique and different. The Modern " +
                        "Times changed the understanding of fashion and drastically altered the decades-long shoemaking traditions. " +
                        "This happened because of new opportunities in technology which made the whole shoemaking process much more " +
                        "easy and simple.\n" +
                        "WHEN DID THE FIRST SHOES APPEAR?\n" +
                        "1991 is an important date in the history of footwear because this is the year when, at the border of Austria " +
                        "and Italy, archeologists found a naturally mummified human named Oetzi from the Stone Age who died about 3300 " +
                        "years before our era. This Alpine traveler was wearing shoes made from deerskin with a sole made from bearskin " +
                        "and stuffed with hay. This is how it’s thought that the Stone Age footwear production technique was like: the " +
                        "fewer stitches, the dryer and warmer the legs, therefore, they wrinkled the leather. The stitches were small " +
                        "and they were not very reliable given the tools people had at that time.\n" +
                        "",
                "$49.00",
                R.drawable.shoe01
            ),
            Shoes(
                2,
                "New Balance 697v4",
                "THE HISTORY AND EVOLUTION OF SHOES\n" +
                        "It’s hard to imagine what life was like when shoes weren’t discovered yet. \n" +
                        "Everything started because of a real and practical need to protect the feet from outside effects. \n" +
                        "This seemingly simple human need turned into a quickly growing industry in which design was just as important \n" +
                        "as functionality. Although the main qualities of footwear have remained unchanged, looking back at the long \n" +
                        "and interesting history of shoes, you can see that the colors, materials and designs did change. \n" +
                        "Before, shoes used to be made by craftsmen. But today, they are part of a factory industry earning \n" +
                        "huge amounts of money each year.\n" +
                        "The history, changes and tendencies in footwear fashion can be divided into the main world history\n" +
                        "During different eras there were different views of the world, different understandings of culture and art, " +
                        "different economic and political factors which played an important role in the materials, shapes, pronts, " +
                        "and style used in people’s wardrobe. The discovery and capture of new lands, new technologies and different " +
                        "understandings of the world changed the style and fashion of footwear.\n" +
                        "Primitive footwear, popular during Prehistory, was changed by sandals which grew in popularity during " +
                        "Antiquity because of the formation of social classes. During the Middle Ages, which are characterized by " +
                        "humility and feudalism, the first footwear structures were formed and the heel was discovered and widely used. " +
                        "During the Early Modern Times were the eras of Renaissance and Baroque during which hints of modern footwear " +
                        "can be spotted. During this time, men’s and women’s shoes were very similar. The models of shoes varied depending " +
                        "on social classes. Also, during the Middle Ages when feudalism was present, society was divided into classes " +
                        "deciding not only different jobs and responsibilities but also different clothes and footwear. Peasants and " +
                        "non-noble townspeople wore heavy and dark leather boots with a heel. Meanwhile, the noble wore more fancy " +
                        "footwear which often had a wooden heel.  Prints, ornaments and other decorative elements were worn only by " +
                        "the noble. They would order these shoes from a shoemaker. Every shoe was different and decorated according " +
                        "to the mood and wishes of the customer, so every single pair of shoes was unique and different. The Modern " +
                        "Times changed the understanding of fashion and drastically altered the decades-long shoemaking traditions. " +
                        "This happened because of new opportunities in technology which made the whole shoemaking process much more " +
                        "easy and simple.\n" +
                        "WHEN DID THE FIRST SHOES APPEAR?\n" +
                        "1991 is an important date in the history of footwear because this is the year when, at the border of Austria " +
                        "and Italy, archeologists found a naturally mummified human named Oetzi from the Stone Age who died about 3300 " +
                        "years before our era. This Alpine traveler was wearing shoes made from deerskin with a sole made from bearskin " +
                        "and stuffed with hay. This is how it’s thought that the Stone Age footwear production technique was like: the " +
                        "fewer stitches, the dryer and warmer the legs, therefore, they wrinkled the leather. The stitches were small " +
                        "and they were not very reliable given the tools people had at that time.\n" +
                        "",
                "$79.00",
                R.drawable.shoe02
            ),
            Shoes(
                3,
                "New Balance 698v4",
                "THE HISTORY AND EVOLUTION OF SHOES\n" +
                        "It’s hard to imagine what life was like when shoes weren’t discovered yet. \n" +
                        "Everything started because of a real and practical need to protect the feet from outside effects. \n" +
                        "This seemingly simple human need turned into a quickly growing industry in which design was just as important \n" +
                        "as functionality. Although the main qualities of footwear have remained unchanged, looking back at the long \n" +
                        "and interesting history of shoes, you can see that the colors, materials and designs did change. \n" +
                        "Before, shoes used to be made by craftsmen. But today, they are part of a factory industry earning \n" +
                        "huge amounts of money each year.\n" +
                        "The history, changes and tendencies in footwear fashion can be divided into the main world history\n" +
                        "During different eras there were different views of the world, different understandings of culture and art, " +
                        "different economic and political factors which played an important role in the materials, shapes, pronts, " +
                        "and style used in people’s wardrobe. The discovery and capture of new lands, new technologies and different " +
                        "understandings of the world changed the style and fashion of footwear.\n" +
                        "Primitive footwear, popular during Prehistory, was changed by sandals which grew in popularity during " +
                        "Antiquity because of the formation of social classes. During the Middle Ages, which are characterized by " +
                        "humility and feudalism, the first footwear structures were formed and the heel was discovered and widely used. " +
                        "During the Early Modern Times were the eras of Renaissance and Baroque during which hints of modern footwear " +
                        "can be spotted. During this time, men’s and women’s shoes were very similar. The models of shoes varied depending " +
                        "on social classes. Also, during the Middle Ages when feudalism was present, society was divided into classes " +
                        "deciding not only different jobs and responsibilities but also different clothes and footwear. Peasants and " +
                        "non-noble townspeople wore heavy and dark leather boots with a heel. Meanwhile, the noble wore more fancy " +
                        "footwear which often had a wooden heel.  Prints, ornaments and other decorative elements were worn only by " +
                        "the noble. They would order these shoes from a shoemaker. Every shoe was different and decorated according " +
                        "to the mood and wishes of the customer, so every single pair of shoes was unique and different. The Modern " +
                        "Times changed the understanding of fashion and drastically altered the decades-long shoemaking traditions. " +
                        "This happened because of new opportunities in technology which made the whole shoemaking process much more " +
                        "easy and simple.\n" +
                        "WHEN DID THE FIRST SHOES APPEAR?\n" +
                        "1991 is an important date in the history of footwear because this is the year when, at the border of Austria " +
                        "and Italy, archeologists found a naturally mummified human named Oetzi from the Stone Age who died about 3300 " +
                        "years before our era. This Alpine traveler was wearing shoes made from deerskin with a sole made from bearskin " +
                        "and stuffed with hay. This is how it’s thought that the Stone Age footwear production technique was like: the " +
                        "fewer stitches, the dryer and warmer the legs, therefore, they wrinkled the leather. The stitches were small " +
                        "and they were not very reliable given the tools people had at that time.\n" +
                        "",
                "$69.00",
                R.drawable.shoe03
            ),
            Shoes(
                4,
                "New Balance 698v4",
                "THE HISTORY AND EVOLUTION OF SHOES\n" +
                        "It’s hard to imagine what life was like when shoes weren’t discovered yet. \n" +
                        "Everything started because of a real and practical need to protect the feet from outside effects. \n" +
                        "This seemingly simple human need turned into a quickly growing industry in which design was just as important \n" +
                        "as functionality. Although the main qualities of footwear have remained unchanged, looking back at the long \n" +
                        "and interesting history of shoes, you can see that the colors, materials and designs did change. \n" +
                        "Before, shoes used to be made by craftsmen. But today, they are part of a factory industry earning \n" +
                        "huge amounts of money each year.\n" +
                        "The history, changes and tendencies in footwear fashion can be divided into the main world history\n" +
                        "During different eras there were different views of the world, different understandings of culture and art, " +
                        "different economic and political factors which played an important role in the materials, shapes, pronts, " +
                        "and style used in people’s wardrobe. The discovery and capture of new lands, new technologies and different " +
                        "understandings of the world changed the style and fashion of footwear.\n" +
                        "Primitive footwear, popular during Prehistory, was changed by sandals which grew in popularity during " +
                        "Antiquity because of the formation of social classes. During the Middle Ages, which are characterized by " +
                        "humility and feudalism, the first footwear structures were formed and the heel was discovered and widely used. " +
                        "During the Early Modern Times were the eras of Renaissance and Baroque during which hints of modern footwear " +
                        "can be spotted. During this time, men’s and women’s shoes were very similar. The models of shoes varied depending " +
                        "on social classes. Also, during the Middle Ages when feudalism was present, society was divided into classes " +
                        "deciding not only different jobs and responsibilities but also different clothes and footwear. Peasants and " +
                        "non-noble townspeople wore heavy and dark leather boots with a heel. Meanwhile, the noble wore more fancy " +
                        "footwear which often had a wooden heel.  Prints, ornaments and other decorative elements were worn only by " +
                        "the noble. They would order these shoes from a shoemaker. Every shoe was different and decorated according " +
                        "to the mood and wishes of the customer, so every single pair of shoes was unique and different. The Modern " +
                        "Times changed the understanding of fashion and drastically altered the decades-long shoemaking traditions. " +
                        "This happened because of new opportunities in technology which made the whole shoemaking process much more " +
                        "easy and simple.\n" +
                        "WHEN DID THE FIRST SHOES APPEAR?\n" +
                        "1991 is an important date in the history of footwear because this is the year when, at the border of Austria " +
                        "and Italy, archeologists found a naturally mummified human named Oetzi from the Stone Age who died about 3300 " +
                        "years before our era. This Alpine traveler was wearing shoes made from deerskin with a sole made from bearskin " +
                        "and stuffed with hay. This is how it’s thought that the Stone Age footwear production technique was like: the " +
                        "fewer stitches, the dryer and warmer the legs, therefore, they wrinkled the leather. The stitches were small " +
                        "and they were not very reliable given the tools people had at that time.\n" +
                        "",
                "$59.00",
                R.drawable.shoe04
            ),
            Shoes(
                5,
                "New Balance 698v4",
                "THE HISTORY AND EVOLUTION OF SHOES\n" +
                        "It’s hard to imagine what life was like when shoes weren’t discovered yet. \n" +
                        "Everything started because of a real and practical need to protect the feet from outside effects. \n" +
                        "This seemingly simple human need turned into a quickly growing industry in which design was just as important \n" +
                        "as functionality. Although the main qualities of footwear have remained unchanged, looking back at the long \n" +
                        "and interesting history of shoes, you can see that the colors, materials and designs did change. \n" +
                        "Before, shoes used to be made by craftsmen. But today, they are part of a factory industry earning \n" +
                        "huge amounts of money each year.\n" +
                        "The history, changes and tendencies in footwear fashion can be divided into the main world history\n" +
                        "During different eras there were different views of the world, different understandings of culture and art, " +
                        "different economic and political factors which played an important role in the materials, shapes, pronts, " +
                        "and style used in people’s wardrobe. The discovery and capture of new lands, new technologies and different " +
                        "understandings of the world changed the style and fashion of footwear.\n" +
                        "Primitive footwear, popular during Prehistory, was changed by sandals which grew in popularity during " +
                        "Antiquity because of the formation of social classes. During the Middle Ages, which are characterized by " +
                        "humility and feudalism, the first footwear structures were formed and the heel was discovered and widely used. " +
                        "During the Early Modern Times were the eras of Renaissance and Baroque during which hints of modern footwear " +
                        "can be spotted. During this time, men’s and women’s shoes were very similar. The models of shoes varied depending " +
                        "on social classes. Also, during the Middle Ages when feudalism was present, society was divided into classes " +
                        "deciding not only different jobs and responsibilities but also different clothes and footwear. Peasants and " +
                        "non-noble townspeople wore heavy and dark leather boots with a heel. Meanwhile, the noble wore more fancy " +
                        "footwear which often had a wooden heel.  Prints, ornaments and other decorative elements were worn only by " +
                        "the noble. They would order these shoes from a shoemaker. Every shoe was different and decorated according " +
                        "to the mood and wishes of the customer, so every single pair of shoes was unique and different. The Modern " +
                        "Times changed the understanding of fashion and drastically altered the decades-long shoemaking traditions. " +
                        "This happened because of new opportunities in technology which made the whole shoemaking process much more " +
                        "easy and simple.\n" +
                        "WHEN DID THE FIRST SHOES APPEAR?\n" +
                        "1991 is an important date in the history of footwear because this is the year when, at the border of Austria " +
                        "and Italy, archeologists found a naturally mummified human named Oetzi from the Stone Age who died about 3300 " +
                        "years before our era. This Alpine traveler was wearing shoes made from deerskin with a sole made from bearskin " +
                        "and stuffed with hay. This is how it’s thought that the Stone Age footwear production technique was like: the " +
                        "fewer stitches, the dryer and warmer the legs, therefore, they wrinkled the leather. The stitches were small " +
                        "and they were not very reliable given the tools people had at that time.\n" +
                        "",
                "$89.00",
                R.drawable.shoe05
            ),
            Shoes(
                6,
                "New Balance 696v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$49.00",
                R.drawable.shoe01
            ),
            Shoes(
                7,
                "New Balance 697v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$79.00",
                R.drawable.shoe02
            ),
            Shoes(
                8,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$69.00",
                R.drawable.shoe03
            ),
            Shoes(
                9,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$59.00",
                R.drawable.shoe04
            ),
            Shoes(
                10,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$89.00",
                R.drawable.shoe05
            ),
            Shoes(
                11,
                "New Balance 696v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$49.00",
                R.drawable.shoe01
            ),
            Shoes(
                12,
                "New Balance 697v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$79.00",
                R.drawable.shoe02
            ),
            Shoes(
                13,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$69.00",
                R.drawable.shoe03
            ),
            Shoes(
                14,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$59.00",
                R.drawable.shoe04
            ),
            Shoes(
                15,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$89.00",
                R.drawable.shoe05
            )
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
}