// #     #   ##    #     #
// ##   ##  #  #   ##   ##
// # # # #   ##    # # # #
// #  #  #  ###    #  #  #
// #     # #   # # #     #
// #     # #    #  #     #
// #     #  ###  # #     #
// LABORATORIO 2
// PLATAFORMAS MÓVILES
// Universidad del Valle de Guatemala
// María Marta Ramírez - 21342

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun processList(inputList: List<Any?>?): List<ItemData>? {
    if (inputList == null) {
        return null
    } else {
        val lista = ArrayList<ItemData>()
        for ((index, element) in inputList.withIndex()) {
            when (element) {
                is Int -> {
                    lista.add(
                        ItemData(
                            originalPos = index,
                            originalValue = element,
                            type = "ENTERO",
                            info = IntegerType(element)
                        )
                    )
                }
                is String -> {
                    lista.add(
                        ItemData(
                            originalPos = index,
                            originalValue = element,
                            type = "CADENA",
                            info = StringType(element)

                        )
                    )
                }
                is Boolean -> {
                    lista.add(
                        ItemData(
                            originalPos = index,
                            originalValue = element,
                            type = "BOOLEANO",
                            info = Booleantype(element)
                        )
                    )
                }
                else -> {
                    if (element != null) {
                        lista.add(
                            ItemData(
                                originalValue = element,
                                originalPos = index,
                                type = null,
                                info = null
                            )
                        )
                    }
                }
            }

        }
        return lista
    }
}


fun IntegerType(valux: Int): String?{
    var type: String? = ""
    if((valux%10) == 0) {
        type = "M10"
    }
    else if ((valux%5) == 0){
        type = "M5"
    }
    else if ((valux%2) == 0){
        type = "M2"
    }
    else {
        type = null;
    }
    return type
}


fun StringType(valux: String): String? {
    return "L" + valux.length
}

fun Booleantype(valux: Boolean): String?{
    if (valux){
        return "VERDADERO"
    }else return "FALSO"