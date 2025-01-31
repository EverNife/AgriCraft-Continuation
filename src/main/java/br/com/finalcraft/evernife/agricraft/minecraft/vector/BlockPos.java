package br.com.finalcraft.evernife.agricraft.minecraft.vector;

import java.util.Objects;

public class BlockPos implements Comparable<BlockPos> {

    private static int floor_double(double value){
        int i = (int) value;
        return value < (double) i ? i - 1 : i;
    }

    protected final int x;
    protected final int y;
    protected final int z;

    public BlockPos(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static BlockPos at(int x, int y, int z){
        return new BlockPos(x, y, z);
    }

    public BlockPos(double x, double y, double z) {
        this.x = floor_double(x);
        this.y = floor_double(y);
        this.z = floor_double(z);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public BlockPos setX(int x){
        return at(x, this.y, this.z);
    }

    public BlockPos setY(int y){
        return at(this.x, y, this.z);
    }

    public BlockPos setZ(int z){
        return at(this.x, this.y, z);
    }

    public BlockPos add(int x, int y, int z){
        return at(this.x + x, this.y + y, this.z + z);
    }

    public BlockPos add(BlockPos blockPos){
        return at(this.x + blockPos.x, this.y + blockPos.y, this.z + blockPos.z);
    }

    public BlockPos add(BlockPos... blockPos){
        int x = this.x;
        int y = this.y;
        int z = this.z;
        for (BlockPos blockPos1 : blockPos) {
            x += blockPos1.x;
            y += blockPos1.y;
            z += blockPos1.z;
        }
        return at(x, y, z);
    }

    public BlockPos subtract(int x, int y, int z){
        return at(this.x - x, this.y - y, this.z - z);
    }

    public BlockPos subtract(BlockPos blockPos){
        return at(this.x - blockPos.x, this.y - blockPos.y, this.z - blockPos.z);
    }

    public BlockPos subtract(BlockPos... blockPos){
        int x = this.x;
        int y = this.y;
        int z = this.z;
        for (BlockPos blockPos1 : blockPos) {
            x -= blockPos1.x;
            y -= blockPos1.y;
            z -= blockPos1.z;
        }
        return at(x, y, z);
    }

    public BlockPos divide(BlockPos other) {
        return this.divide(other.x, other.y, other.z);
    }

    public BlockPos divide(int x, int y, int z) {
        return at(this.x / x, this.y / y, this.z / z);
    }

    public BlockPos divide(int n) {
        return this.divide(n, n, n);
    }

    public BlockPos multiply(BlockPos other) {
        return this.multiply(other.x, other.y, other.z);
    }

    public BlockPos multiply(int x, int y, int z) {
        return at(this.x * x, this.y * y, this.z * z);
    }

    public BlockPos multiply(BlockPos... blockPos) {
        int x = this.x;
        int y = this.y;
        int z = this.z;
        for (BlockPos blockPos1 : blockPos) {
            x *= blockPos1.x;
            y *= blockPos1.y;
            z *= blockPos1.z;
        }
        return at(x, y, z);
    }

    public BlockPos multiply(int n) {
        return this.multiply(n, n, n);
    }

    public BlockPos boundX(int min, int max) {
        if (this.y < min) {
            return this.setY(min);
        } else if (this.y > max) {
           return this.setY(max);
        }
        return this;
    }

    public BlockPos boundY(int min, int max) {
        if (this.y < min) {
            return this.setY(min);
        } else if (this.y > max) {
            return this.setY(max);
        }
        return this;
    }

    public BlockPos boundZ(int min, int max) {
        if (this.y < min) {
            return this.setY(min);
        } else if (this.y > max) {
            return this.setY(max);
        }
        return this;
    }

    public double distance(BlockPos other) {
        return Math.sqrt(distanceSq(other));
    }

    public int distanceSq(BlockPos other) {
        int dx = other.getX() - this.getX();
        int dy = other.getY() - this.getY();
        int dz = other.getZ() - this.getZ();
        return dx * dx + dy * dy + dz * dz;
    }

    public boolean containedWithin(BlockPos min, BlockPos max) {
        return this.getX() >= min.getX()
            && this.getX() <= max.getX()
            && this.getY() >= min.getY()
            && this.getY() <= max.getY()
            && this.getZ() >= min.getZ()
            && this.getZ() <= max.getZ();
    }

    public ChunkPos getChunkPos(){
        return new ChunkPos(this);
    }

    @Override
    public int compareTo(BlockPos o) {
        if (this.getY() == o.getY()) {
            return this.getZ() == o.getZ() ? this.getX() - o.getX() : this.getZ() - o.getZ();
        } else {
            return this.getY() - o.getY();
        }
    }

    @Override
    public String toString() {
        return serialize();
    }

    public String serialize(){
        return this.x + "|" + this.y + "|" + this.z;
    }

    public static BlockPos deserialize(String string){
        String[] split = string.split("\\|");
        return at(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockPos blockPos = (BlockPos) o;
        return x == blockPos.x && y == blockPos.y && z == blockPos.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
