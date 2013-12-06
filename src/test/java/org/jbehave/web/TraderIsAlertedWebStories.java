package org.jbehave.web;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(parameterConverters=ParameterConverters.EnumConverter.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false, ignoreFailureInView = false)
@UsingSpring(resources = { "org/jbehave/web/configuration.xml",
           "org/jbehave/web/tradingService-webacceptancetest.xml" })
public class TraderIsAlertedWebStories extends InjectableEmbedder {

	@Test
	public void run() throws Throwable {
		injectedEmbedder().runStoriesAsPaths(storyPaths());
	}

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromPath("src/test/resources"), "org/jbehave/web/user_submits_feedback_in_web.story", "");
       // List<String> pathToStory = Arrays.asList("resources/org/jbehave/web/*.story");

  //      List<String> pathToStory = Arrays.asList("resources/org/jbehave/web/user_submits_feedback_in_web.story");
   //     return pathToStory;
    }

}
