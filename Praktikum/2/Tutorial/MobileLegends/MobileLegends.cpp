#include <stdio.h>
#include <iostream>
#include "Hero.hpp"
#include "Tigreal.hpp"
#include "Layla.hpp"

using namespace std;

int main() {

    Layla *l1 = new Layla(10, 1000); 
    l1->useSkill();
    Layla *l2 = new Layla(*l1);
    l1->Hero::heal(5);
    Layla *l3 = new Layla(50, 200);
    l3->moveTo(15, 30);
    *l3 = *l2;

    Tigreal *t1 = new Tigreal(200, 10);
    t1->moveTo(5, 15);
    t1->taunt(10);

    Tigreal *t2 = new Tigreal(*t1);
    Tigreal *t3 = new Tigreal(400, 20);
    t3->sacredHammer();

    Tigreal *t4 = new Tigreal(*t3);
    t1->useSkill();
    t3->useSkill();

    Tigreal *t5 = new Tigreal(300, 15);
    t5->moveTo(10, 20);

    Tigreal *t6 = new Tigreal(*t5);
    t6->taunt(5);

    delete t6;
    // delete l1;
    // delete l2;
    // delete l3;
    delete l3;
    delete l2;
    delete l1;

    delete t5;
    delete t4;
    delete t3;
    delete t2;
    delete t1;

    return 0;
}
