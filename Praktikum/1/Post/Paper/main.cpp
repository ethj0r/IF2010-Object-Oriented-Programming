#include "Paper.hpp"

int main() {
    Paper *a = new Paper('A');
    Paper b('B');
    Paper *c = new Paper('C');
    Paper *d = new Paper(*c);

    a->fold();
    b.fold();
    c->fold();
    c->glue();

    delete a;

    c->setName('X');

    d->fold();
    d->glue();

    delete d;
    delete c;

    return 0;
}
