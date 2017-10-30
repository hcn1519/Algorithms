//
//  main.swift
//  BOJ_3047
//
//  Created by 홍창남 on 2017. 10. 24..
//  Copyright © 2017년 홍창남. All rights reserved.
//

// Swift 3.1
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

var ri = ReadInput()

let temp = ri.readLineToArray()
let tempInt = temp.map { return Int($0)! }
let order = ri.read()

let sortedArr = tempInt.sorted()

var result: [Int] = []
for c in order {
    switch c {
    case "A":
        result.append(sortedArr[0])
    case "B":
        result.append(sortedArr[1])
    default:
        result.append(sortedArr[2])
    }
}

print(result[0], result[1], result[2], separator: " ", terminator: "\n")






