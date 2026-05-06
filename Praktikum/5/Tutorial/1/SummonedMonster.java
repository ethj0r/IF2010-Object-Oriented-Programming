public class SummonedMonster implements ISummoned {
    private Monster monster;
    private boolean isFaceUp;
    private boolean isAttacking;

    public SummonedMonster(Monster monster, boolean isFaceUp, boolean isAttacking) {
        this.monster = monster;
        this.isFaceUp = isFaceUp;
        this.isAttacking = isAttacking;
    }

    @Override
    public void render() {
        String msg = "Monster ";
        msg += this.monster.getName();
        msg += " dalam keadaan ";
        if (this.isFaceUp) {
            msg += "terbuka";
        } else {
            msg += "tertutup";
        }
        msg += " dengan posisi ";
        if (this.isAttacking) {
            msg += "menyerang";
        } else {
            msg += "bertahan";
        }
        System.out.println(msg);
    }

    @Override
    public boolean flip() {
        if (!this.isFaceUp) {
            this.isFaceUp = true;
            return true;
        }
        return false;
    }

    @Override
    public void rotate() {
        this.isAttacking = !this.isAttacking;
    }

    @Override
    public int getPositionValue() {
        if (this.isAttacking) {
            return this.monster.getAttackValue();
        }
        return this.monster.getDefenseValue();
    }
}