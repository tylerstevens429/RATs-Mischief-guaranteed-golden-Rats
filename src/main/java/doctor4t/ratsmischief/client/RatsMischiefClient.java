package doctor4t.ratsmischief.client;

import doctor4t.ratsmischief.client.render.entity.RatEntityRenderer;
import doctor4t.ratsmischief.common.RatsMischief;
import doctor4t.ratsmischief.common.init.ModEntities;
import doctor4t.ratsmischief.common.init.ModParticles;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class RatsMischiefClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		ModParticles.registerFactories();
		ModParticles.init();

		EntityRendererRegistry.register(ModEntities.RAT, RatEntityRenderer::new);

		// model predicates
		FabricModelPredicateProviderRegistry.register(new Identifier(RatsMischief.MOD_ID + ":filled"), (itemStack, world, livingEntity, seed) -> itemStack.getOrCreateSubNbt(RatsMischief.MOD_ID).getFloat("filled"));


//		// block render layer map
//		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlock.MOD_BLOCK);

//		// entity renderer registration
//		EntityRendererRegistry.register(ModEntities.MOD_ENTITY, ModEntityRenderer::new);
	}
}
