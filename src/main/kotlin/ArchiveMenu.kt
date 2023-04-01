import java.util.Scanner
val scan = Scanner(System.`in`)

class ArchiveMenu() : Menu(){
    override val title: String = "Список архивов:"
    override var lastMenuPoint = 1
    //Список пунктов меню - заголовок и действие, которое необходимо выполнить при выборе пункта
    override val menuPoints:MutableList<MenuPoint> = mutableListOf(
        MenuPoint("0. Создать архив", {menuPointIndex:Int -> addMenuPoint()}),
        MenuPoint("1. Выход",{menuPointIndex:Int -> quit()})
    )

    override fun addMenuPoint(){
        println("Введите название архива")
        val name = scan.nextLine()
        archives.add(Archive(name))
        noteMenu.add(NoteMenu(archives.size-1))
        lastMenuPoint = lastMenuPoint+1
        menuPoints.add(MenuPoint("$lastMenuPoint. $name") { menuPointIndex: Int ->
            noteMenu[menuPointIndex].printMenu()
        })

        println("Архив \'$name\" добавлен")
        printMenu()
    }

    override fun quit(){
        println("Выполнение программы завершено")
    }
}