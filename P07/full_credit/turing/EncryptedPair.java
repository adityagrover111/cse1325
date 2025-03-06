package turing;

// EncryptedPair is essentially a struct to hold the encrypted string along with
//   the decrypted hashcode.
//
// (I had planned to recognize a successful decryption when the decrypted text
//    ended with GO MAVS, but Enigma is good at partial decryptions - who knew?
//    Thus I got a lot of false positives, which wrecked havoc with my timings. 
//  I finally gave up and just went with the decrypted string's hashcode 
//    to be certain when I had a full and correct decryption. 
//  Interesting algorithm, Enigma!)

class EncryptedPair {
    public EncryptedPair(String encrypted, int decryptedHashcode) {
        this.encrypted = encrypted;
        this.decryptedHashcode = decryptedHashcode;
    }
    @Override
    public String toString() {
        return encrypted + "\n" + decryptedHashcode;
    }
    public String encrypted;
    public int decryptedHashcode;
}

