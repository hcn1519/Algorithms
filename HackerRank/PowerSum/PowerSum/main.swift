//
//  main.swift
//  PowerSum
//
//  Created by 홍창남 on 2017. 10. 30..
//  Copyright © 2017년 홍창남. All rights reserved.
//

import Foundation


func powerSum(total: Int, power: Double, num: Double) -> Int {

    let value = total - Int(pow(num, power))

    if value < 0{
        return 0
    } else if value == 0 {
        return 1
    } else {
        return powerSum(total: value, power: power, num: num + 1) + powerSum(total: total, power: power, num: num + 1)
    }
}

let total = Int(readLine()!)!
let power = Double(readLine()!)!

print(powerSum(total: total, power: power, num: 1))
