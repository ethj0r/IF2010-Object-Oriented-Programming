#include <iostream>
#include <string>
using namespace std;


/**
 * SOAL 2 – EXCEPTION HIERARCHY
 * @brief Membuat abstract QueueException dengan method what() yang mengembalikan info tipe exception
 *        Kelas turunan QueueException dapat menangani 2 jenis exceptions:
 *              - Suatu Queue telah kosong
 *              - Suatu Queue telah penuh
 */
class QueueException {
    public:
        virtual ~QueueException() {}
        virtual string what() const = 0; //pure virtual
};

class QueueEmptyException : public QueueException {
    public:
        string what() const override {
            return "Queue telah kosong";
        }
};

class QueueFullException : public QueueException {
    public:
        string what() const override {
            return "Queue telah penuh";
        }
};

/**
 * SOAL 1 – GENERIC QUEUE CLASS
 * @brief Buat sebuah kelas Queue generik dengan kapasitas max 3 elemen.
 *        Kelas harus memiliki minimal:
 *              - default ctor
 *              - dtor
 *              - method enqueue, untuk memasukkan sebuah elemen ke dalam Queue.
 *                      Method ini akan melempar sebuah exception jika Queue sudah penuh
 *              - method dequeuee, untuk mengeluarkan sebuah elemen ke dalam Queue.
 *                      Method ini akan melempar sebuah exception jika Queue kosong.
 *              - operator overloading << untuk menampilkan isi Queue (bentuk tampilan bebas).
 */

template <class T>
class Queue {
    private:
        static const int CAPACITY = 3;
        T* data;
        int count; //current elmt

    public:
        Queue() : count(0) {
            data = new T[CAPACITY];
        }

        ~Queue() {
            delete[] data;
        }

        void enqueue(const T& value) {
            if (count == CAPACITY) throw QueueFullException();
            data[count] = value;
            ++count;
        }

        T dequeue() {
            if (count == 0) throw QueueEmptyException();
            T front = data[0];
            for (int i=0; i<count; i++) {
                data[i-1] = data[i];
            }
            --count;
            return front;
        }

        friend ostream& operator<<(ostream& os, const Queue<T>& q) {
            os << "Elemen: ";
            for (int i=0; i<q.count; ++i) {
                os << " " << q.data[i];
            }
            return os;
        }
};

/**
 * SOAL 3b – custom class buat testing generic
 * @brief minimal 1 tipe data customized, yakni Queue of Mobil (definisi kelas Mobil dibebaskan)
 */
class Mobil {
    private:
        string merk;
        int tahun;
    public:
        Mobil() : merk("unknown"), tahun(0) {}
        Mobil(string merk, int tahun) : merk(merk), tahun(tahun) {}
        friend ostream& operator<<(ostream& os, const Mobil& m) {
            os << m.merk << "(" << m.tahun << ")";
            return os;
        }
};

/**
 * SOAL 3, 4 OVERAL
 * @brief main program
 */
int main() {
    Queue<int> q;

    try {
        q.dequeue();
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    try {
        q.enqueue(8);
        q.enqueue(6);
        q.enqueue(4);
        cout << q << endl;
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    try {
        q.enqueue(9);
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    try {
        int x = q.dequeue();
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    try {
        q.enqueue(2);
        cout << q << endl; 
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    try {
        int x = q.dequeue();
        cout << "Dequeue: " << x << endl;
        cout << q << endl;
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    cout << "\nQueue of Float -----------------" << endl;
    Queue<float> qf;
    try {
        qf.enqueue(1.5f);
        qf.enqueue(2.7f);
        qf.enqueue(3.14f);
        cout << qf << endl;
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    cout << "\nQueue of Mobil -----------------" << endl;
    Queue<Mobil> qm;
    try {
        qm.enqueue(Mobil("Toyota", 2020));
        qm.enqueue(Mobil("Honda", 2021));
        qm.enqueue(Mobil("Suzuki", 2022));
        cout << qm << endl;
    } catch (const QueueException& e) {
        cout << e.what() << endl;
    }

    return 0;
}
