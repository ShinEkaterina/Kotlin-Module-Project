//Список архивов
val archives: MutableList<Archive> = mutableListOf()
//Основное меню (меню архивов)
var archiveMenu:ArchiveMenu = ArchiveMenu()
//Список меню заметок для каждого архива
val noteMenu: MutableList<NoteMenu> = mutableListOf()

fun main() {
    archiveMenu.printMenu()
}
