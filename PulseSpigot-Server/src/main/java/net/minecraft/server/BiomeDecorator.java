package net.minecraft.server;

import java.util.Random;

public class BiomeDecorator {

    protected World a;
    protected Random b;
    protected BlockPosition c;
    protected CustomWorldSettingsFinal d;
    protected WorldGenerator e = new WorldGenClay(4);
    protected WorldGenerator f;
    protected WorldGenerator g;
    protected WorldGenerator h;
    protected WorldGenerator i;
    protected WorldGenerator j;
    protected WorldGenerator k;
    protected WorldGenerator l;
    protected WorldGenerator m;
    protected WorldGenerator n;
    protected WorldGenerator o;
    protected WorldGenerator p;
    protected WorldGenerator q;
    protected WorldGenerator r;
    protected WorldGenFlowers s;
    protected WorldGenerator t;
    protected WorldGenerator u;
    protected WorldGenerator v;
    protected WorldGenerator w;
    protected WorldGenerator x;
    protected WorldGenerator y;
    protected int z;
    protected int A;
    protected int B;
    protected int C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    public boolean L;

    // Migot start
    protected BiomeDecorator createShallowCopy() {
        return new BiomeDecorator(this);
    }

    protected BiomeDecorator(BiomeDecorator decorator) {
        this.f = decorator.f;
        this.g = decorator.g;
        this.s = decorator.s;
        this.t = decorator.t;
        this.u = decorator.u;
        this.v = decorator.v;
        this.w = decorator.w;
        this.x = decorator.x;
        this.y = decorator.y;
        this.z = decorator.z;
        this.A = decorator.A;
        this.B = decorator.B;
        this.C = decorator.C;
        this.D = decorator.D;
        this.E = decorator.E;
        this.F = decorator.F;
        this.G = decorator.G;
        this.H = decorator.H;
        this.I = decorator.I;
        this.J = decorator.J;
        this.K = decorator.K;
        this.L = decorator.L;
    }
    // Migot end

    public BiomeDecorator() {
        this.f = new WorldGenSand(Blocks.SAND, 7);
        this.g = new WorldGenSand(Blocks.GRAVEL, 6);
        this.s = new WorldGenFlowers(Blocks.YELLOW_FLOWER, BlockFlowers.EnumFlowerVarient.DANDELION);
        this.t = new WorldGenMushrooms(Blocks.BROWN_MUSHROOM);
        this.u = new WorldGenMushrooms(Blocks.RED_MUSHROOM);
        this.v = new WorldGenHugeMushroom();
        this.w = new WorldGenReed();
        this.x = new WorldGenCactus();
        this.y = new WorldGenWaterLily();
        this.B = 2;
        this.C = 1;
        this.H = 1;
        this.I = 3;
        this.J = 1;
        this.L = true;
    }

    public void a(World world, Random random, BiomeBase biomebase, BlockPosition blockposition) {
        if (this.a != null) {
            // Migot start
            BiomeDecorator decorator = this.createShallowCopy();
            decorator.a = world;
            String s = world.getWorldData().getGeneratorOptions();
            if (s != null) {
                decorator.d = CustomWorldSettingsFinal.CustomWorldSettings.a(s).b();
            } else {
                decorator.d = CustomWorldSettingsFinal.CustomWorldSettings.a("").b();
            }
            decorator.b = random;
            decorator.c = blockposition;
            decorator.h = new WorldGenMinable(Blocks.DIRT.getBlockData(), decorator.d.I);
            decorator.i = new WorldGenMinable(Blocks.GRAVEL.getBlockData(), decorator.d.M);
            decorator.j = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.GRANITE), decorator.d.Q);
            decorator.k = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.DIORITE), decorator.d.U);
            decorator.l = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.ANDESITE), decorator.d.Y);
            decorator.m = new WorldGenMinable(Blocks.COAL_ORE.getBlockData(), decorator.d.ac);
            decorator.n = new WorldGenMinable(Blocks.IRON_ORE.getBlockData(), decorator.d.ag);
            decorator.o = new WorldGenMinable(Blocks.GOLD_ORE.getBlockData(), decorator.d.ak);
            decorator.p = new WorldGenMinable(Blocks.REDSTONE_ORE.getBlockData(), decorator.d.ao);
            decorator.q = new WorldGenMinable(Blocks.DIAMOND_ORE.getBlockData(), decorator.d.as);
            decorator.r = new WorldGenMinable(Blocks.LAPIS_ORE.getBlockData(), decorator.d.aw);
            decorator.a(biomebase);
            decorator.a = null;
            decorator.b = null;
            // Migot end
        } else {
            this.a = world;
            String s = world.getWorldData().getGeneratorOptions();

            if (s != null) {
                this.d = CustomWorldSettingsFinal.CustomWorldSettings.a(s).b();
            } else {
                this.d = CustomWorldSettingsFinal.CustomWorldSettings.a("").b();
            }

            this.b = random;
            this.c = blockposition;
            this.h = new WorldGenMinable(Blocks.DIRT.getBlockData(), this.d.I);
            this.i = new WorldGenMinable(Blocks.GRAVEL.getBlockData(), this.d.M);
            this.j = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.GRANITE), this.d.Q);
            this.k = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.DIORITE), this.d.U);
            this.l = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.ANDESITE), this.d.Y);
            this.m = new WorldGenMinable(Blocks.COAL_ORE.getBlockData(), this.d.ac);
            this.n = new WorldGenMinable(Blocks.IRON_ORE.getBlockData(), this.d.ag);
            this.o = new WorldGenMinable(Blocks.GOLD_ORE.getBlockData(), this.d.ak);
            this.p = new WorldGenMinable(Blocks.REDSTONE_ORE.getBlockData(), this.d.ao);
            this.q = new WorldGenMinable(Blocks.DIAMOND_ORE.getBlockData(), this.d.as);
            this.r = new WorldGenMinable(Blocks.LAPIS_ORE.getBlockData(), this.d.aw);
            this.a(biomebase);
            this.a = null;
            this.b = null;
        }
    }

    protected void a(BiomeBase biomebase) {
        this.a();

        int i;
        int j;
        int k;

        for (i = 0; i < this.I; ++i) {
            j = this.b.nextInt(16) + 8;
            k = this.b.nextInt(16) + 8;
            this.f.generate(this.a, this.b, this.a.r(this.c.a(j, 0, k)));
        }

        for (i = 0; i < this.J; ++i) {
            j = this.b.nextInt(16) + 8;
            k = this.b.nextInt(16) + 8;
            this.e.generate(this.a, this.b, this.a.r(this.c.a(j, 0, k)));
        }

        for (i = 0; i < this.H; ++i) {
            j = this.b.nextInt(16) + 8;
            k = this.b.nextInt(16) + 8;
            this.g.generate(this.a, this.b, this.a.r(this.c.a(j, 0, k)));
        }

        i = this.A;
        if (this.b.nextInt(10) == 0) {
            ++i;
        }

        int l;
        BlockPosition blockposition;

        for (j = 0; j < i; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            WorldGenTreeAbstract worldgentreeabstract = biomebase.a(this.b);

            worldgentreeabstract.e();
            blockposition = this.a.getHighestBlockYAt(this.c.a(k, 0, l));
            if (worldgentreeabstract.generate(this.a, this.b, blockposition)) {
                worldgentreeabstract.a(this.a, this.b, blockposition);
            }
        }

        for (j = 0; j < this.K; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            this.v.generate(this.a, this.b, this.a.getHighestBlockYAt(this.c.a(k, 0, l)));
        }

        BlockPosition blockposition1;
        int i1;
        int j1;

        for (j = 0; j < this.B; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() + 32;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);
                blockposition1 = this.c.a(k, j1, l);
                BlockFlowers.EnumFlowerVarient blockflowers_enumflowervarient = biomebase.a(this.b, blockposition1);
                BlockFlowers blockflowers = blockflowers_enumflowervarient.a().a();

                if (blockflowers.getMaterial() != Material.AIR) {
                    this.s.a(blockflowers, blockflowers_enumflowervarient);
                    this.s.generate(this.a, this.b, blockposition1);
                }
            }
        }

        for (j = 0; j < this.C; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);
                biomebase.b(this.b).generate(this.a, this.b, this.c.a(k, j1, l));
            }
        }

        for (j = 0; j < this.D; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);
                (new WorldGenDeadBush()).generate(this.a, this.b, this.c.a(k, j1, l));
            }
        }

        for (j = 0; j < this.z; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);

                BlockPosition blockposition2;

                for (blockposition1 = this.c.a(k, j1, l); blockposition1.getY() > 0; blockposition1 = blockposition2) {
                    blockposition2 = blockposition1.down();
                    if (!this.a.isEmpty(blockposition2)) {
                        break;
                    }
                }

                this.y.generate(this.a, this.b, blockposition1);
            }
        }

        for (j = 0; j < this.E; ++j) {
            if (this.b.nextInt(4) == 0) {
                k = this.b.nextInt(16) + 8;
                l = this.b.nextInt(16) + 8;
                BlockPosition blockposition3 = this.a.getHighestBlockYAt(this.c.a(k, 0, l));

                this.t.generate(this.a, this.b, blockposition3);
            }

            if (this.b.nextInt(8) == 0) {
                k = this.b.nextInt(16) + 8;
                l = this.b.nextInt(16) + 8;
                i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
                if (i1 > 0) {
                    j1 = this.b.nextInt(i1);
                    blockposition1 = this.c.a(k, j1, l);
                    this.u.generate(this.a, this.b, blockposition1);
                }
            }
        }

        if (this.b.nextInt(4) == 0) {
            j = this.b.nextInt(16) + 8;
            k = this.b.nextInt(16) + 8;
            l = this.a.getHighestBlockYAt(this.c.a(j, 0, k)).getY() * 2;
            if (l > 0) {
                i1 = this.b.nextInt(l);
                this.t.generate(this.a, this.b, this.c.a(j, i1, k));
            }
        }

        if (this.b.nextInt(8) == 0) {
            j = this.b.nextInt(16) + 8;
            k = this.b.nextInt(16) + 8;
            l = this.a.getHighestBlockYAt(this.c.a(j, 0, k)).getY() * 2;
            if (l > 0) {
                i1 = this.b.nextInt(l);
                this.u.generate(this.a, this.b, this.c.a(j, i1, k));
            }
        }

        for (j = 0; j < this.F; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);
                this.w.generate(this.a, this.b, this.c.a(k, j1, l));
            }
        }

        for (j = 0; j < 10; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);
                this.w.generate(this.a, this.b, this.c.a(k, j1, l));
            }
        }

        if (this.b.nextInt(32) == 0) {
            j = this.b.nextInt(16) + 8;
            k = this.b.nextInt(16) + 8;
            l = this.a.getHighestBlockYAt(this.c.a(j, 0, k)).getY() * 2;
            if (l > 0) {
                i1 = this.b.nextInt(l);
                (new WorldGenPumpkin()).generate(this.a, this.b, this.c.a(j, i1, k));
            }
        }

        for (j = 0; j < this.G; ++j) {
            k = this.b.nextInt(16) + 8;
            l = this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(this.c.a(k, 0, l)).getY() * 2;
            if (i1 > 0) {
                j1 = this.b.nextInt(i1);
                this.x.generate(this.a, this.b, this.c.a(k, j1, l));
            }
        }

        if (this.L) {
            for (j = 0; j < 50; ++j) {
                k = this.b.nextInt(16) + 8;
                l = this.b.nextInt(16) + 8;
                i1 = this.b.nextInt(248) + 8;
                if (i1 > 0) {
                    j1 = this.b.nextInt(i1);
                    blockposition1 = this.c.a(k, j1, l);
                    (new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(this.a, this.b, blockposition1);
                }
            }

            for (j = 0; j < 20; ++j) {
                k = this.b.nextInt(16) + 8;
                l = this.b.nextInt(16) + 8;
                i1 = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
                blockposition = this.c.a(k, i1, l);
                (new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(this.a, this.b, blockposition);
            }
        }

    }

    protected void a(int i, WorldGenerator worldgenerator, int j, int k) {
        int l;

        if (k < j) {
            l = j;
            j = k;
            k = l;
        } else if (k == j) {
            if (j < 255) {
                ++k;
            } else {
                --j;
            }
        }

        for (l = 0; l < i; ++l) {
            BlockPosition blockposition = this.c.a(this.b.nextInt(16), this.b.nextInt(k - j) + j, this.b.nextInt(16));

            worldgenerator.generate(this.a, this.b, blockposition);
        }

    }

    protected void b(int i, WorldGenerator worldgenerator, int j, int k) {
        for (int l = 0; l < i; ++l) {
            BlockPosition blockposition = this.c.a(this.b.nextInt(16), this.b.nextInt(k) + this.b.nextInt(k) + j - k, this.b.nextInt(16));

            worldgenerator.generate(this.a, this.b, blockposition);
        }

    }

    protected void a() {
        this.a(this.d.J, this.h, this.d.K, this.d.L);
        this.a(this.d.N, this.i, this.d.O, this.d.P);
        this.a(this.d.V, this.k, this.d.W, this.d.X);
        this.a(this.d.R, this.j, this.d.S, this.d.T);
        this.a(this.d.Z, this.l, this.d.aa, this.d.ab);
        this.a(this.d.ad, this.m, this.d.ae, this.d.af);
        this.a(this.d.ah, this.n, this.d.ai, this.d.aj);
        this.a(this.d.al, this.o, this.d.am, this.d.an);
        this.a(this.d.ap, this.p, this.d.aq, this.d.ar);
        this.a(this.d.at, this.q, this.d.au, this.d.av);
        this.b(this.d.ax, this.r, this.d.ay, this.d.az);
    }
}
