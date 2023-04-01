class NoteMenu(val index: Int) : Menu(){
    override val title: String = "Меню выбора заметки для архива \'${archives[index].name}\'"
    override var lastMenuPoint = 1
    override fun quit() {
        archiveMenu.printMenu()
    }

    override val menuPoints:MutableList<MenuPoint> = mutableListOf(
        MenuPoint("0. Создать заметку", {index:Int -> addMenuPoint()}),
        MenuPoint("1. Выход",{index:Int -> quit()})
    )
    override fun addMenuPoint(){
        println("Введите название заметки")
        val name = scan.nextLine()
        println("Введите текст заметки")
        val text = scan.nextLine()
        archives[index].notes.add(Note(name,text))
        lastMenuPoint = lastMenuPoint+1
        menuPoints.add(MenuPoint("$lastMenuPoint. $name",{
            println(archives[index].notes[lastMenuPoint-2].content)
            printMenu()
        }))
        println("Заметка \'$name\" добавлена")
        printMenu()
    }
}