# 🚀 Packer Unpacker - Java File Archiving Utility (CUI Based)

> A comprehensive command-line Java application to simulate real-world file archiving and extraction. This project merges the power of low-level byte stream operations with object-oriented design to demonstrate how `.txt` files can be packed into a single archive and later unpacked back into their original state.

---



## ✨ Features

- 🔄 Pack multiple `.txt`or other files into a single custom archive.
- 📤 Unpack the archive to recover the original text files.
- 🔐 Uses fixed 100-byte headers to retain file metadata (name and size).
- 🧠 Memory-efficient: processes files using buffered streams.
- 📦 Does not use any external libraries or frameworks.
- 🧩 Modular design using OOP (Object-Oriented Programming).
- 💬 Built-in help section and guided input prompts.

---

## 🎥 Demo

```
+----------------------------------------------------------+
|---- Devang Packer Unpacker Complete CUI Module -----------|
+----------------------------------------------------------+
Welcome to the Packer Unpacker Application!

Please choose an option from the menu below:
1. Packing
2. Unpacking
3. Help
4. Exit
```

---

## ⚙️ Getting Started

### ✅ Requirements:

- Java 21 or later
- Terminal/Command Prompt

### 🧪 To Run:

```bash
javac Packing_Unpacking_Final.java
java Packer_Unpacker.Packing_Unpacking_Final
```

---

## 🧠 How It Works

### 🔹 Packing

1. User enters a directory path.
2. Application filters and reads all `.txt` files.
3. Adds a 100-byte header for each file containing its name and size.
4. Writes each file's content after its respective header.
5. Final packed file is created.

### 🔹 Unpacking

1. User enters the packed file name.
2. Application reads headers and retrieves original filenames and sizes.
3. Extracts and recreates original files.

---

## 📁 Project Structure

```
Packer_Unpacker/
├── Packing_Unpacking_Final.java     # Main application entry
├── PackingFunctionality             # Handles packing logic
└── UnpackingFunctionality           # Handles unpacking logic
```

---

## 🛠 Technologies Used

- **Java** (JDK 21+)
- `File`, `FileInputStream`, `FileOutputStream`
- `Scanner` for user input
- CLI (Command Line Interface)

---


## 🚧 Future Enhancements

- Add support for all file types (`.jpg`, `.pdf`, etc.)
- Implement actual compression algorithms (e.g., Huffman, LZW)
- GUI version using JavaFX or Swing
- Recursive folder traversal
- Add integrity checks and file validations

---


