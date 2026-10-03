package archives.tater.biomeroots;

import archives.tater.biomeroots.datagen.BlockTagsProvider;
import archives.tater.biomeroots.datagen.ModBiomeSpreadProvider;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BiomeRootsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();
		pack.addProvider(BlockTagsProvider::new);
		pack.addProvider(ModBiomeSpreadProvider::new);
	}
}
