abstract class Menu {
    abstract val title:String
    abstract val menuPoints:MutableList<MenuPoint>
    abstract val lastMenuPoint:Int

//Проверка состоит ли строка только из цифр
    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
//Печать меню
    open fun printMenu(){
        println(title)
        for (i in 0..menuPoints.size-1){
            println(menuPoints[i].title)
        }
        println("Введите номер пункта меню и нажмите Enter")
        chooseOption()
    }
//Обработка ввода пользователя при выборе пункта меню
    fun chooseOption(){
        var madeChoice = false
        var userInput = ""
        while(!madeChoice){
            userInput = scan.nextLine()
            //Если ввод содержит буквы или ввод это число вне диапозона существующих пунктов меню
            if ((!isNumeric(userInput))||(userInput.toInt() > lastMenuPoint)) {
                println("Неверная команда. Попробуйте снова")
                printMenu()
            }
            else madeChoice = true
        }
        executeComand(userInput)
    }

    fun executeComand(comand: String){
        when (comand){
            "0" -> menuPoints[0].action.invoke(0)
            "1" -> menuPoints[1].action.invoke(1)
            else -> menuPoints[comand.toInt()].action.invoke(comand.toInt()-2)
        }
    }

    abstract fun quit()
    abstract fun addMenuPoint()
}