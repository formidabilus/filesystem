package com.rtjvm.scala.oop.filesystem

import java.util.Scanner

import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.commands.Command

object Filesystem  extends App {

  val root = Directory.ROOT

  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    currentState.show
    Command.from(newLine).apply(currentState)

  })

  //  var state = State(root, root)
//
//  val scanner = new Scanner(System.in )
//
//  while (true) {
//    state.show
//    val input = scanner.nextLine()
//    state = Command.from(input).apply(state)
//  }
}
