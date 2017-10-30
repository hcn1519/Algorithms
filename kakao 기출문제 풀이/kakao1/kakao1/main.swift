//
//  main.swift
//  kakao1
//
//  Created by 홍창남 on 2017. 9. 19..
//  Copyright © 2017년 홍창남. All rights reserved.
//

import Foundation

func problem1(n: Int, arr1: [Int], arr2: [Int]) {

    let binaryArr1 = generateBinaryArray(arr: arr1, length: n)
    let binaryArr2 = generateBinaryArray(arr: arr2, length: n)

    var finalArr: [[Int]] = []
    var finalResult: [String] = []

    for i in 0..<n {

        var row: [Int] = []
        var item: String = ""

        for j in 0..<n {
            if binaryArr1[i][j] == 1 || binaryArr2[i][j] == 1 {
                item.append("#")
                row.append(1)
            } else {
                item.append(" ")
                row.append(0)
            }
        }

        finalArr.append(row)
        finalResult.append(item)

    }
    print(finalResult)

}

// 십진수를 이진수로
func decimalToBinary(input: Int) -> [Int] {
    var input = input

    var result: [Int] = []

    while input > 1 {
        let q = input / 2
        let remainder = input % 2

        result.append(remainder)

        input = q
    }
    result.append(input)

    return result
}

// 이진수 배열 만들기
func generateBinaryArray(arr: [Int], length: Int) -> [[Int]] {
    var binaryArr: [[Int]] = []
    for item in arr {
        var row = decimalToBinary(input: item)

        // 부족한 0 채워주기
        if row.count < length {
            let shouldAddZero = length - row.count

            for _ in 1...shouldAddZero {
                row.append(0)
            }
        }
        // 거꾸로 들어가서 반전
        row = row.reversed()

        binaryArr.append(row)
    }
    return binaryArr
}


let n = 5
let arr1 = [9, 20, 28, 18, 11]
let arr2 = [30, 1, 21, 17, 28]

problem1(n: n, arr1: arr1, arr2: arr2)

let m = 6
let arr3 = [46, 33, 33 ,22, 31, 50]
let arr4 = [27 ,56, 19, 14, 14, 10]

problem1(n: m, arr1: arr3, arr2: arr4)
