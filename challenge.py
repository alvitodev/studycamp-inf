class UndoRedoSystem:
    def __init__(self):
        self.undo_stack = []  # Menyimpan aksi yang sudah dilakukan
        self.redo_stack = []  # Menyimpan aksi yang di-undo
 
    def add_action(self, action):
        """Menambahkan aksi baru dan menghapus redo stack"""
        # * Tambahkan action ke dalam undo stack *
        # \ Ketikkan kodenya di sini \
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
        # \ Ketikkan kodenya di sini \ 
        print(f"Undo: {action}")
 
    def redo(self):
        """Mengulang aksi yang di-undo"""
        if not self.redo_stack:
            print("No actions to redo.")
            return
        # * Hapus action dari stack redo * 
        # \ Ketikkan kodenya di sini \
        self.undo_stack.append(action)
        print(f"Redo: {action}")
 
    def show_history(self):
        """Menampilkan aksi yang sudah dilakukan"""
        print("\n=== Action History ===")
        # * Tampilkan riwayat undo dan redo di bawah sini *
        # \ Cetak kode riwayat undo di sini \
        # \ Cetak kode riwayat redo di sini \
        print("======================\n")
 
# Contoh penggunaan
editor = UndoRedoSystem()
# * Tambahkan action Anda sendiri *
 
editor.show_history()
 
editor.undo()  
editor.undo()  
editor.show_history()
 
editor.redo()
editor.show_history()
