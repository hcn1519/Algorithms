//: Playground - noun: a place where people can play

import UIKit
//import Foundation

struct Stack<T> {
    fileprivate var array = [T]()
    
    public func isEmpty() -> Bool {
        return array.isEmpty
    }
    
    public mutating func push(_ element: T) {
        array.append(element)
    }
    
    public mutating func pop() -> T? {
        return array.popLast()
    }
    public var top: Int {
        return (array.count - 1)
    }
}

struct Bracket {
    var type: Character!
    var position: Int!
    
    func match(c: Character!) -> Bool {
        if self.type == "[" && c == "]" {
            return true
        }
        if self.type == "{" && c == "}" {
            return true
        }
        if self.type == "(" && c == ")" {
            return true
        }
        return false
    }
}

let text: String! = "()"

var isSuccess: Bool = true
var failIndex: Int = -1
var index = 0

var openingStack = Stack<Bracket>()


StringIterator: for next in text.characters {
    if next == "(" || next == "[" || next == "{" {
        let newBracket = Bracket(type: next, position: index)
        openingStack.push(newBracket)
    }
    
    if next == ")" || next == "]" || next == "}" {
        
        // empty check
        if openingStack.isEmpty() {
            isSuccess = false
            failIndex = index + 1
            break StringIterator
        }
        
        // match check
        let temp = openingStack.pop()!
        
        if !temp.match(c: next) {
            isSuccess = false
            failIndex = index + 1
            break StringIterator
        }
    }
    
    index += 1
}

if isSuccess {
    
    if openingStack.isEmpty() {
        print("Success")
    } else {
        let newBracket = openingStack.pop()!
        isSuccess = false
        failIndex = newBracket.position
        
        print(failIndex)
    }
} else {
    print(failIndex)
}

