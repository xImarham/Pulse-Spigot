package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class StructureStart {

    protected final List<StructurePiece> a = java.util.Collections.synchronizedList(Lists.newArrayList()); // Paper - synchronized list // PulseSpigot - LinkedList -> ArrayList
    protected StructureBoundingBox b;
    private int c;
    private int d;

    public StructureStart() {}

    public StructureStart(int i, int j) {
        this.c = i;
        this.d = j;
    }

    public StructureBoundingBox a() {
        return this.b;
    }

    public List<StructurePiece> b() { // PulseSpigot - LinkedList -> ArrayList
        return this.a;
    }

    public void a(World world, Random random, StructureBoundingBox structureboundingbox) {
        Iterator iterator = this.a.iterator();

        synchronized (this.a) { // PulseSpigot - synchronize
        while (iterator.hasNext()) {
            StructurePiece structurepiece = (StructurePiece) iterator.next();

            if (structurepiece.c().a(structureboundingbox) && !structurepiece.a(world, random, structureboundingbox)) {
                iterator.remove();
            }
        }} // PulseSpigot
    }

    protected void c() {
        this.b = StructureBoundingBox.a();
        synchronized (this.a) { // Paper - synchronize
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            StructurePiece structurepiece = (StructurePiece) iterator.next();

            this.b.b(structurepiece.c());
        }} // Paper
    }

    public NBTTagCompound a(int i, int j) {
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        nbttagcompound.setString("id", WorldGenFactory.a(this));
        nbttagcompound.setInt("ChunkX", i);
        nbttagcompound.setInt("ChunkZ", j);
        nbttagcompound.set("BB", this.b.g());
        NBTTagList nbttaglist = new NBTTagList();
        synchronized (this.a) { // PulseSpigot - synchronize
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            StructurePiece structurepiece = (StructurePiece) iterator.next();

            nbttaglist.add(structurepiece.b());
        }} // PulseSpigot

        nbttagcompound.set("Children", nbttaglist);
        this.a(nbttagcompound);
        return nbttagcompound;
    }

    public void a(NBTTagCompound nbttagcompound) {}

    public void a(World world, NBTTagCompound nbttagcompound) {
        this.c = nbttagcompound.getInt("ChunkX");
        this.d = nbttagcompound.getInt("ChunkZ");
        if (nbttagcompound.hasKey("BB")) {
            this.b = new StructureBoundingBox(nbttagcompound.getIntArray("BB"));
        }

        NBTTagList nbttaglist = nbttagcompound.getList("Children", 10);

        for (int i = 0; i < nbttaglist.size(); ++i) {
            this.a.add(WorldGenFactory.b(nbttaglist.get(i), world));
        }

        this.b(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {}

    protected void a(World world, Random random, int i) {
        int j = world.F() - i;
        int k = this.b.d() + 1;

        if (k < j) {
            k += random.nextInt(j - k);
        }

        int l = k - this.b.e;

        this.b.a(0, l, 0);
        synchronized (this.a) { // Paper - synchronize
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            StructurePiece structurepiece = (StructurePiece) iterator.next();

            structurepiece.a(0, l, 0);
        }} // Paper
    }

    protected void a(World world, Random random, int i, int j) {
        int k = j - i + 1 - this.b.d();
        boolean flag = true;
        int l;

        if (k > 1) {
            l = i + random.nextInt(k);
        } else {
            l = i;
        }

        int i1 = l - this.b.b;

        this.b.a(0, i1, 0);
        synchronized (this.a) { // Paper - synchronize
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            StructurePiece structurepiece = (StructurePiece) iterator.next();

            structurepiece.a(0, i1, 0);
        }} // Paper
    }

    public boolean d() {
        return true;
    }

    public boolean a(ChunkCoordIntPair chunkcoordintpair) {
        return true;
    }

    public void b(ChunkCoordIntPair chunkcoordintpair) {}

    public int e() {
        return this.c;
    }

    public int f() {
        return this.d;
    }
}
