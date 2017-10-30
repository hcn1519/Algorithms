import Foundation

protocol StandardInput {
    mutating func readLineToArray() -> [String]
    mutating func read() -> String
    mutating func readInt() -> Int
    mutating func readDouble() -> Double
}

struct ReadInput: StandardInput {

    private var currentIndex: Int = 0
    private var inputArray: [String] = []

    // 데이터를 배열로 변환
    public mutating func readLineToArray() -> [String] {
        let result = readLine()!
        let resultArray = result.components(separatedBy: " ")
        return resultArray
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

struct Person {
    var name: String
    var key: String?
}

var people: [Person] = []
var group: [String: Int] = [:]

func groupCheck(group people: [Person], person1: String, person2: String) -> (Int, Int) {

    var index1: Int = -1
    var index2: Int = -1

    for (index, p) in people.enumerated() {
        if p.name == person1 {
            index1 = index
        } else if p.name == person2 {
            index2 = index
        }
    }
    return (index1, index2)
}

func makeGroup(person1: String, person2: String) {
    let place = groupCheck(group: people, person1: person1, person2: person2)


    if place.0 == -1 && place.1 == -1 {

        // 둘 다 포함된 그룹이 없는 경우
        let p1 = Person(name: person1, key: person1)
        let p2 = Person(name: person2, key: person1)

        people.append(p1)
        people.append(p2)

        group.updateValue(2, forKey: person1)

        print(2)
        return
    }


    // 한 명만 그룹에 포함된 경우
    if place.0 != -1 && place.1 == -1 {
        // 0이 그룹 있음
        var p2 = Person(name: person2, key: nil)

        p2.key = people[place.0].key

        people.append(p2)

        group[p2.key!]! += 1

        print(group[p2.key!]!)
        return
    } else if place.1 != -1 && place.0 == -1 {
        // 1이 그룹 있음
        var p1 = Person(name: person1, key: nil)

        p1.key = people[place.1].key

        people.append(p1)

        group[p1.key!]! += 1

        print(group[p1.key!]!)

        return
    }


    // 둘 다 포함된 그룹이 있는 경우
    let prevKey = people[place.1].key
    let updateKey = people[place.0].key
    var counter = 0
    for item in people {
        var item = item
        if item.key == prevKey {
            item.key = updateKey
            counter += 1
        }

    }
    group[people[place.0].key!]! += counter

    print(group[people[place.0].key!]!)
}


var ri = ReadInput()

let num = ri.readInt()


for _ in 1...num {
  let count = ri.readInt()

  for _ in 1...count {

    let friends = ri.readLineToArray()

    makeGroup(person1: friends[0], person2: friends[1])
  }
  people.removeAll()
  group.removeAll()
}
