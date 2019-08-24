package com.indivara.auliariwayanto.memberiddevtest.data

object RewardData {
    private var data = arrayOf(
            arrayOf(
                    "Vouchers",
                    "500.000 Poin",
                    "mentimun_accent",
                    "Vouchers Onokabe",
                    "https://api.vold.io/pictures/5b6d0de29b16965f695c436a/images/3ab632e3-8438-47d6-bd44-a287e7e30533.jpg"
            ),
            arrayOf(
                    "Vouchers",
                    "200.000 Poin",
                    "mentimun_accent",
                    "Vouchers McDonald",
                    "https://1851franchise.com/uploads/cat_images/2e7d583e0aa6aea18f2e58406e3e9b094709.jpg"
            ),
            arrayOf(
                    "Products",
                    "Sneaker Shoes",
                    "mentimun_accent",
                    "All Converse Product Free",
                    "https://images-na.ssl-images-amazon.com/images/I/71yYdcycp6L._UX395_.jpg"

            ),
            arrayOf(
                    "GiftCard",
                    "Mie Ayam Pak Yanto",
                    "mentimun_background_content_grey",
                    "Makan Sepuasnya",
                    "https://cdn0-production-images-kly.akamaized.net/NKIRDU1GXjLIhYGUyhiQPVfg3zU=/680x383/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2551953/original/026155800_1545214543-cara-membuat-mie-ayam.jpg"

            ),
            arrayOf(
                    "GiftCard",
                    "Ayam Bakar Wong Solo",
                    "mentimun_background_content_grey",
                    "Happy Weekend",
                    "https://cdn2.tstatic.net/travel/foto/bank/images/ayam-bakar-wong-solo_20180225_111232.jpg"
            ),
            arrayOf(
                    "Products",
                    "Fossil Watch",
                    "yellow_800",
                    "Diskon hingga 50%",
                    "https://media.wired.com/photos/5c6763a53416472d347be247/master/pass/fossil.jpg"

            ),
            arrayOf(
                    "Vouchers",
                    "100.000 Poin",
                    "yellow_800",
                    "Paket Belanja Ace Hardware",
                    "https://villageace.com/wp-content/uploads/2018/08/village-home-hardware.jpg"

            ),
            arrayOf(
                    "Vouchers",
                    "50.000 Poin",
                    "red_800",
                    "Giant Shopping",
                    "https://media.wired.com/photos/5c9040ee4950d24718d6da99/master/pass/shoppingcart-1066110386.jpg"
            ),
            arrayOf(
                    "Products",
                    "Samsung A Series",
                    "red_800",
                    "Seluruh Outlet Samsung",
                    "https://au-images.shop.samsung.com/medias/galaxy-s10-tile.jpg?context=bWFzdGVyfGltYWdlc3wxNTY5MXxpbWFnZS9qcGVnfGltYWdlcy9oM2MvaDUyLzkyMTU2NzIwOTA2NTQuanBnfDQwZGM4OTUxYjFmYWM1ZTBlNjJjZjQxZGZiMWM2ZjVjYmM2MTc3NGEzYmU5ZTNiZmViNzRhZjY1MzkwZGU5NDE"

            ),
            arrayOf(
                    "Giftcard",
                    "Eiger Bag",
                    "red_800",
                    "Nikmati Diskon hingga 30%",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/1/22/1399906/1399906_70948792-1884-448d-97c3-96df9bd505d4.jpg"

            )
    )
    val listData: ArrayList<Identification>
        get() {
            val list = ArrayList<Identification>()
            for (aData in data) {
                val reward = Identification()
                reward.name = aData[0]
                reward.poin = aData[1]
                reward.color = aData[2]
                reward.nominal = aData[3]
                reward.linkImage = aData[4]
                list.add(reward)
            }
            return list
        }
}