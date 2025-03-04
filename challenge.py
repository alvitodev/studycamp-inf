class UndoRedoSystem:
    def __init__(self):
        self.undo_stack = []  # Menyimpan aksi yang sudah dilakukan
        self.redo_stack = []  # Menyimpan aksi yang di-undo

    def add_action(self, action):
        """Menambahkan aksi baru dan menghapus redo stack"""
        # * Tambahkan action ke dalam undo stack *
        self.undo_stack.append(action) 
        self.redo_stack.clear()  # Reset redo stack karena ada aksi baru
        print(f"Action added: {action}")

    def undo(self):
        """Mengembalikan ke aksi sebelumnya"""
        if not self.undo_stack:
            print("No actions to undo.")
            return
        # Hapus action dari stack undo
        action = self.undo_stack.pop()
        # * Tambahkan action ke stack redo * 
        self.redo_stack.append(action)  
        print(f"Undo: {action}")

    def redo(self):
        """Mengulang aksi yang di-undo"""
        if not self.redo_stack:
            print("No actions to redo.")
            return
        # * Hapus action dari stack redo * 
        action = self.redo_stack.pop() 
        self.undo_stack.append(action) 
        print(f"Redo: {action}")

    def show_history(self):
        """Menampilkan aksi yang sudah dilakukan"""
        print("\n=== Action History ===")
        # * Tampilkan riwayat undo dan redo di bawah sini *
        print("Undo Stack:", self.undo_stack) 
        print("Redo Stack:", self.redo_stack)  
        print("======================\n")

# Contoh penggunaan
editor = UndoRedoSystem()

editor.add_action("Type 'Hello'") 
editor.add_action("Type 'World'") 
editor.add_action("Delete 'World'")  

editor.show_history()

editor.undo()  
editor.undo()  
editor.show_history()

editor.redo()
editor.show_history()
