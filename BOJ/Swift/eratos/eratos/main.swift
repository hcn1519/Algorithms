//
//  main.swift
//  eratos
//
//  Created by 홍창남 on 2017. 10. 19..
//  Copyright © 2017년 홍창남. All rights reserved.
//

import Foundation

struct ReadInput {

    private var currentIndex: Int = 0
    private var inputArray: [String] = []

    // 데이터를 배열로 변환
    public mutating func readLineToArray() -> [String] {

        guard let result = readLine() else {
            return []
        }

        return result.components(separatedBy: " ")
    }

    // 띄어쓰기 단위로 String 읽기
    public mutating func read() -> String {
        if inputArray.count == 0 {
            inputArray = self.readLineToArray()
        }
        let result = inputArray[inputArray.index(after: currentIndex-1)]
        currentIndex += 1

        if currentIndex == inputArray.count {
            self.inputArray.removeAll()
            self.currentIndex = 0
        }

        return result
    }

    // Int 데이터 읽기
    public mutating func readInt() -> Int {
        guard let result = Int(self.read()) else {
            fatalError("Int형 데이터가 아닙니다.")
        }

        return result
    }

    // Double 데이터 읽기
    public mutating func readDouble() -> Double {
        guard let result = Double(self.read()) else {
            fatalError("Double형 데이터가 아닙니다.")
        }

        return result
    }
}
struct Stack<E> {
    var items = [E]()
    mutating func push(_ item: E) {
        items.append(item)
    }
    mutating func pop() -> E? {
        if !self.isEmpty {
            return items.removeLast()
        }
        return nil
    }
    var isEmpty: Bool {
        return items.isEmpty
    }
}

print("구하고자 하는 수의 약수를 출력합니다. 입력")

var ri = ReadInput()
let n = ri.readInt()

var result = [1]

var st = Stack<Int>()
st.push(n)

var i = 2
let sqr = Int(sqrt(Double(n)) + 1)

while(i < sqr) {
    if n % i == 0 {
        result.append(i)
        if n/i != i {
            st.push(n/i)
        }
    }
    i += 1
}

while(!st.isEmpty){
    result.append(st.pop()!)
}

print(result.count)

