//
//  main.swift
//  BOJ_11375
//
//  Created by 홍창남 on 2017. 10. 24..
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

var ri = ReadInput()

let numberOfEmploy = ri.readInt()
let numberOfWork = ri.readInt()

var result = Array(repeatElement(-1, count: numberOfWork))

var employ: [[Int]] = []

for i in 1...numberOfEmploy {

    let input = ri.readLineToArray()

    let inputNum = input.map { return Int($0)! }

    var temp = Array(repeatElement(-1, count: inputNum[0]))
    for i in temp.indices {
        temp[i] = inputNum[i+1]
    }
    employ.append(temp)
}

print(employ)
//
//for i in 0..<numberOfEmploy {
//    var allHaveSeats = false
//    for k in employ[i] {
//        if result[k-1] == -1 {
//            result[k-1] = i
//            allHaveSeats = true
//            break
//        }
//    }
//
//    if allHaveSeats {
//        continue
//    }
//
////    for k in employ[i] {
////        let needNewWork = result[k-1]
////        for x in employ[needNewWork] {
////            if result[x-1] == -1 {
////                result[x-1] = needNewWork
////                break
////            }
////        }
////    }
//
////    print(result)
////    let needNewWork: Int = result[k-1]
////    for x in employ[needNewWork] {
////        if result[k-1] == -1 {
////            result[k-1] = needNewWork
////            break
////        }
////    }
//}

print(result)
