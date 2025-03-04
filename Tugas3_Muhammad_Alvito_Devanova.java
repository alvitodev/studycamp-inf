import java.util.*;

class Buku {
	String judul;
	String penulis;
	int id;

	Buku(String judul, String penulis, int id) {
		this.judul = judul;
		this.penulis = penulis;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | " + judul + " - " + penulis;
	}
}

class Node {
	String namaKaryawan;
	String tanggalBergabung;
	Node next;

	Node(String nama, String tanggal) {
		this.namaKaryawan = nama;
		this.tanggalBergabung = tanggal;
		this.next = null;
	}
}

public class Tugas3_Muhammad_Alvito_Devanova {
	// a. Array untuk daftar buku
	private Buku[] daftarBuku = new Buku[10];
	private int jumlahBuku = 0;

	// b. Stack untuk histori peminjaman
	private Stack<String> historiPeminjaman = new Stack<>();

	// c. Queue untuk antrian peminjaman
	private Queue<String> antrianPeminjam = new LinkedList<>();

	// d. LinkedList untuk daftar karyawan
	private Node headKaryawan;

	// Test class untuk isi daftar buku
	public Tugas3_Muhammad_Alvito_Devanova() {
		tambahBuku("Laskar Pelangi", "Andrea Hirata", 1);
		tambahBuku("Bumi Manusia", "Pramoedya Ananta Toer", 2);
		tambahBuku("Ronggeng Dukuh Paruk", "Ahmad Tohari", 3);
	}

	// a. Array - tambah & cari buku
	public void tambahBuku(String judul, String penulis, int id) {
		if (jumlahBuku < 10) { // maksimal 10
			daftarBuku[jumlahBuku] = new Buku(judul, penulis, id);
			jumlahBuku++;
			System.out.println("Buku berhasil ditambahkan!");
		} else {
			System.out.println("Kapasitas buku penuh!");
		}
	}

	public void cariBuku(String judul) {
		for (int i = 0; i < jumlahBuku; i++) {
			if (daftarBuku[i].judul.toLowerCase().contains(judul.toLowerCase())) {
				System.out.println("Buku ditemukan: " + daftarBuku[i]);
				return;
			}
		}
		System.out.println("Buku tidak ditemukan!");
	}

	// b. stack - histori pinjam
	public void tambahHistori(String transaksi) {
		if (historiPeminjaman.size() < 5) { // histori maksimal 5 states
			historiPeminjaman.push(transaksi);
			System.out.println("Histori ditambahkan: " + transaksi);
		} else {
			historiPeminjaman.remove(0); // hapus yang lama
			historiPeminjaman.push(transaksi);
			System.out.println("Histori ditambahkan (menggantikan yang terlama): " + transaksi);
		}
	}

	public void hapusTransaksiTerbaru() {
		if (!historiPeminjaman.isEmpty()) {
			System.out.println("Transaksi dihapus: " + historiPeminjaman.pop());
		} else {
			System.out.println("Tidak ada histori transaksi!");
		}
	}

	public void tampilkanHistori() {
		System.out.println("Histori Peminjaman: " + historiPeminjaman);
	}

	// c. queue - antrian
	public void tambahAntrian(String nama) {
		if (antrianPeminjam.size() < 5) {
			antrianPeminjam.add(nama);
			System.out.println(nama + " masuk antrian");
		} else {
			System.out.println("Antrian penuh!");
		}
	}

	public void layaniPeminjam() {
		if (!antrianPeminjam.isEmpty()) {
			System.out.println("Melayani: " + antrianPeminjam.poll());
		} else {
			System.out.println("Tidak ada antrian!");
		}
	}

	public void tampilkanAntrian() {
		System.out.println("Antrian saat ini: " + antrianPeminjam);
	}

	// d. LinkedList - daftar karyawan
	public void tambahKaryawan(String nama, String tanggal) {
		Node newNode = new Node(nama, tanggal);
		if (headKaryawan == null) {
			headKaryawan = newNode;
		} else {
			Node current = headKaryawan;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		System.out.println("Karyawan " + nama + " ditambahkan");
	}

	public void tampilkanKaryawan() {
		Node current = headKaryawan;
		System.out.println("Daftar karyawan:");
		while (current != null) {
			System.out.println("- " + current.namaKaryawan + " (Bergabung: " + current.tanggalBergabung + ")");
			current = current.next;
		}
	}

	// Main method untuk testingan
	public static void main(String[] args) {
		Tugas3_Muhammad_Alvito_Devanova perpustakaan = new Tugas3_Muhammad_Alvito_Devanova();

		// Array
		System.out.println("\n=== Test Array (Daftar Buku)");
		perpustakaan.cariBuku("Laskar");

		// Stack
		System.out.println("\n=== Test Stack (Histori Peminjaman)");
		perpustakaan.tambahHistori("Pinjam: Laskar Pelangi - Affiev");
		perpustakaan.tambahHistori("Pinjam: Bumi Manusia - Budi");
		perpustakaan.tampilkanHistori();
		perpustakaan.hapusTransaksiTerbaru();
		perpustakaan.tampilkanHistori();

		// Queue
		System.out.println("\n=== Test Queue (Antrian peminjam)");
		perpustakaan.tambahAntrian("Ambon");
		perpustakaan.tambahAntrian("Batak");
		perpustakaan.tambahAntrian("Cepot");
		perpustakaan.tampilkanAntrian();
		perpustakaan.layaniPeminjam();
		perpustakaan.tampilkanAntrian();

		// LinkedList
		System.out.println("\n=== Test LinkedList (Daftar karyawan)");
		perpustakaan.tambahKaryawan("Mode", "01-01-2023");
		perpustakaan.tambahKaryawan("Jam", "01-06-2023");
		perpustakaan.tambahKaryawan("Terbang", "01-01-2024");
		perpustakaan.tampilkanKaryawan();
	}
}
