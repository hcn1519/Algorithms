import Foundation

func printP(_ item: String, _ lineNum: Int) -> String {
  var line: String = ""
  var x = ""
  for (index, val) in item.characters.enumerated() {
    if index == 0 {
      continue
    }

    let a = index+1
    if (a % 3) == 0 {
      x = "*"
    } else {
      x = "#"
    }

    if a % 3 == 2 && item.characters.count != a {
      switch lineNum {
      case 1:
        line += ".\(x).."
      case 2:
        line += "\(x).\(x)."
      case 3:
        line += ".\(val).*"
      case 4:
        line += "\(x).\(x)."
      case 5:
        line += ".\(x).."
      default:
        fatalError()
      }
    } else {
      switch lineNum {
      case 1:
        line += ".\(x).."
      case 2:
        line += "\(x).\(x)."
      case 3:
        line += ".\(val).\(x)"
      case 4:
        line += "\(x).\(x)."
      case 5:
        line += ".\(x).."
      default:
        fatalError()
      }
    }

  }
  return line
}


let input = readLine()
var first = true
var line1: String = ""
var line2: String = ""
var line3: String = ""
var line4: String = ""
var line5: String = ""


var x: String = "#"

if first {
  line1 += "..\(x).."
  line2 += ".\(x).\(x)."
  line3 += "\(x).\(input![input!.startIndex]).\(x)"
  line4 += ".\(x).\(x)."
  line5 += "..\(x).."
  first = false
}

if input!.characters.count != 1 {
    line1 += printP(input!, 1)
    line2 += printP(input!, 2)
    line3 += printP(input!, 3)
    line4 += printP(input!, 4)
    line5 += printP(input!, 5)
}


print(line1)
print(line2)
print(line3)
print(line4)
print(line5)
