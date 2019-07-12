package com.jstarcraft.rns.recommend.collaborative.ranking;

import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.rns.configure.Configuration;
import com.jstarcraft.rns.evaluate.ranking.AUCEvaluator;
import com.jstarcraft.rns.evaluate.ranking.MAPEvaluator;
import com.jstarcraft.rns.evaluate.ranking.MRREvaluator;
import com.jstarcraft.rns.evaluate.ranking.NDCGEvaluator;
import com.jstarcraft.rns.evaluate.ranking.NoveltyEvaluator;
import com.jstarcraft.rns.evaluate.ranking.PrecisionEvaluator;
import com.jstarcraft.rns.evaluate.ranking.RecallEvaluator;
import com.jstarcraft.rns.recommend.collaborative.ranking.SLIMRecommender;
import com.jstarcraft.rns.task.RankingTask;

public class SLIMTestCase {

	@Test
	public void testRecommender() throws Exception {
		Configuration configuration = Configuration.valueOf("recommend/collaborative/ranking/slim-test.properties");
		RankingTask job = new RankingTask(SLIMRecommender.class, configuration);
		Map<String, Float> measures = job.execute();
		Assert.assertThat(measures.get(AUCEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.93500406F));
		Assert.assertThat(measures.get(MAPEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.49976474F));
		Assert.assertThat(measures.get(MRREvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.6658492F));
		Assert.assertThat(measures.get(NDCGEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.5933353F));
		Assert.assertThat(measures.get(NoveltyEvaluator.class.getSimpleName()), CoreMatchers.equalTo(18.260979F));
		Assert.assertThat(measures.get(PrecisionEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.3593051F));
		Assert.assertThat(measures.get(RecallEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.6413308F));
	}

}
