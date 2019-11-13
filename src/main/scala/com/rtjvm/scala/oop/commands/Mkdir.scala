package com.rtjvm.scala.oop.commands
import com.rtjvm.scala.oop.Files.Directory
import com.rtjvm.scala.oop.filesystem.State

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    } else {
      doMkdir(state, name)
    }
}

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = {
    val wd = state.wd
    val fullPath = wd.path

    // 1. all the directories in the full path

    // 2. create new directory entry in the wd

    // 3. update the whole directory structure starting from root
    // (the directory structure is IMMUTABLE)

    // 4. find new working directory INSTANCE given wd's full path, in the NEW directory structure
  }
}
