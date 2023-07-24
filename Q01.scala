import scala.io.StdIn

def main(args:Array[String]) : Unit = {
    print("Enter the text: ")
    var text = StdIn.readLine()
    print("Enter the shift: ")
    val shift = StdIn.readInt()

    val encryptedText = caesarCipher(text, "encrypt", shift)
    println(s"Encrypted: $encryptedText")

    val decryptedText = caesarCipher(encryptedText, "decrypt", shift)
    println(s"Decrypted: $decryptedText")
}

def encrypt(text: String, shift: Int): String = {
    val encryptedText = text.map { char =>
        if (char.isLetter) {
            val base = if (char.isUpper) 'A' else 'a'
            ((char - base + shift) % 26 + base).toChar
        } 
        else {
            char
        }
    }
    encryptedText
}

def decrypt(ciphertext: String, shift: Int): String = {
    encrypt(ciphertext, -shift) 
}


def caesarCipher(data: String, operation: String, shift: Int): String = {
    if (operation == "encrypt") {
        encrypt(data, shift)
    } 
    else if (operation == "decrypt") {
        decrypt(data, shift)
    } 
    else {
        throw new IllegalArgumentException("Invalid operation. Use 'encrypt' or 'decrypt'.")
    }
}