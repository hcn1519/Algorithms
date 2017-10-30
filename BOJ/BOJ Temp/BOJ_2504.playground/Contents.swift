//: Playground - noun: a place where people can play

import UIKit

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

var st = Stack<Character>()

//let str = "(()[[]])"
let str = "(())"

var result = 0
var temp = 0

var multiplier = Stack<Int>()
// ( ( ) [ [ ] ]
// 2 2   3 3
// 2 * (2 + 3*3)

// (2[3])

var currentBracket = Stack<Int>()

// result = 2
for item in str.characters {
    switch item {
    case "(":
        st.push(item)
        multiplier.push(2)
    case "[":
        st.push(item)
        multiplier.push(3)
    case ")":
        let popedItem = st.pop()
        if popedItem != "(" {
            result = 0
            break
        }
        
        
        let val = multiplier.pop()
        
        
        if !currentBracket.isEmpty() {
            
            temp += val!
            
        } else {
            temp = 0
            currentBracket.push(2)
        }
        
        
        
    case "]":
        let popedItem = st.pop()
        if popedItem != "[" {
            result = 0
            break
        }
        
        let val = multiplier.pop()
        if multiplier.isEmpty() {
            result += (val!*3)
        }
        
    default:
        break
    }
}



var str1 = "123"

print(Int(String(str1[str1.index(str1.startIndex, offsetBy: 0)]))!)
print(str1[str1.index(str1.startIndex, offsetBy: 1)])
print(str1[str1.index(after: str1.startIndex)])

for (index, value) in str1.characters.enumerated() {
    print(index)
    print(value)
}

