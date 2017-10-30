//: Playground - noun: a place where people can play

import UIKit

func getTime(timeStr: String) -> Date {

    let timeArr = timeStr.components(separatedBy: ":")

    var component = DateComponents()
    component.hour = Int(timeArr[0])
    component.minute = Int(timeArr[1])

    var calendar = Calendar(identifier: .gregorian)
    calendar.timeZone = TimeZone(abbreviation: "GMT+0.00")!

    return calendar.date(from: component)!
}

func whenToCome(n: Int, t: Int, m: Int, timeTable: [String]) {

    var busArrivalTimes: [String] = ["09:00"]
    var hour = "9"
    var min = "0"

    for _ in 1..<n {
        var newMin = Int(min)! + t


        if newMin >= 60 {
            newMin %= 60
            min = String(newMin)

            let newHour = Int(hour)! + 1
            print("\(newHour):\(newMin)")
        }

//        let resultTIme =
    }
//
//    for timeStr in timeTable {
//        let timeArr = timeStr.components(separatedBy: ":")
//
//        let min = timeArr[1]
//
//
//    }


}
//whenToCome(n: 1, t: 1, m: 2, timeTable: [""])

let n = [1, 2, 2, 1, 1, 10]
let t = [1, 10, 1, 1, 1, 60]
let m = [5, 2, 2, 5, 1, 45]
let timeTables = [["08:00", "08:01", "08:02", "08:03"],
                  ["09:10", "09:09", "08:00"],
                  ["09:00", "09:00", "09:00", "09:00"],
                  ["00:01", "00:01", "00:01", "00:01", "00:01"],
                  ["23:59"],
                  ["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]
                  ]
let result = ["09:00", "09:09", "08:59","00:00", "09:00", "18:00"]

for i in 0..<timeTables.count {
    whenToCome(n: n[i], t: t[i], m: m[i], timeTable: timeTables[i])
}



