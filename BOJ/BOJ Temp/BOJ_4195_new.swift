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

class Person {
    var name: String
    var rank: Int
    var numberOfFriends: Int
    var parent: Person?

    init(name: String) {
        self.name = name
        self.rank = 0
        self.numberOfFriends = 0
        self.parent = nil
    }

    func getParent() -> Person {
        var me = self

        guard var parent = self.parent else {
            return me
        }

        while me.name != parent.name {
            self.parent = parent.parent

            me = parent
            if let p = me.parent {
                parent = p
            }

        }

        return me.parent!
    }
}

var people: [String: Person] = [:]

func mergeTable(person1: String, person2: String) {

    // 둘 모두 그룹에 없음
    if people[person1] == nil && people[person2] == nil {
        let p1 = Person(name: person1)
        let p2 = Person(name: person2)

        p1.parent = p1
        p2.parent = p1
        p1.numberOfFriends = 2

        people.updateValue(p1, forKey: person1)
        people.updateValue(p2, forKey: person2)


    // 한 명만 그룹 있음
    } else if people[person1] != nil && people[person2] == nil {
        let p2 = Person(name: person2)
        let px = people[person1]?.getParent()

        p2.parent = px
        px?.numberOfFriends += 1

        people.updateValue(p2, forKey: person2)

    // 한 명만 그룹 있음
    } else if people[person1] == nil && people[person2] != nil {
        let p1 = Person(name: person1)
        let px = people[person2]?.getParent()

        p1.parent = px
        px?.numberOfFriends += 1

        people.updateValue(p1, forKey: person1)
    // 둘 모두 그룹 있음
    } else {
        let px = people[person1]?.getParent()
        let py = people[person2]?.getParent()

        px?.numberOfFriends += (py?.numberOfFriends)!
        py?.parent = px
    }

}

var ri = ReadInput()

let num = ri.readInt()


for _ in 1...num {
  let count = ri.readInt()

  for _ in 1...count {

    let friends = ri.readLineToArray()

    mergeTable(person1: friends[0], person2: friends[1])

    print((people["Fred"]!.parent?.numberOfFriends)!)
  }
  people.removeAll()
}
