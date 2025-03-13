// Package declaration for the application
package com.nexera.articleapp

// Importing necessary Android and Compose libraries
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexera.articleapp.ui.theme.MyComposeApplicationTheme

/**
 * MainActivity is the entry point of the application.
 * It sets up the UI using Jetpack Compose and applies the app's theme.
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is created.
     * Sets up the Compose UI and applies the app's theme.
     *
     * @param savedInstanceState The saved instance state of the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content of the activity using Jetpack Compose
        setContent {
            // Apply the app's theme
            MyComposeApplicationTheme {
                // A surface container that uses the background color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), // Fill the entire screen
                    color = MaterialTheme.colorScheme.background // Use the background color from the theme
                ) {
                    // Use a Column to arrange composables vertically
                    Column {
                        // Display the ArticleTopic composable
                        ArticleTopic()
                    }
                }
            }
        }
    }
}

/**
 * ArticleTopic is a composable function that displays an article with a banner image,
 * a title, sub-content, and main content.
 *
 * @param modifier The modifier to apply to the layout. Defaults to an empty Modifier.
 */
@Composable
fun ArticleTopic(modifier: Modifier = Modifier) {
    // Define font size and padding for consistent styling
    val fontTextSize = 18.sp // Font size for sub-content and main content
    val itemPadding = 16.dp // Padding around text and images

    // Create a vertically scrollable column to display article content
    LazyColumn(
        modifier = modifier, // Apply the provided modifier
        horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
        verticalArrangement = Arrangement.spacedBy(16.dp) // Add spacing between items
    ) {
        // Display the banner image
        item {
            // Load the banner image from resources
            val bannerImage = painterResource(id = R.drawable.bg_compose_background)
            // Display the image with the provided modifier
            Image(
                painter = bannerImage,
                contentDescription = null, // Provide a meaningful description for accessibility if needed
                modifier = Modifier.fillMaxWidth() // Ensure the image takes the full width of its container
            )
        }

        // Display the article title
        item {
            Text(
                text = stringResource(id = R.string.article_title), // Load title from resources
                fontSize = 24.sp, // Set a larger font size for the title
                fontWeight = FontWeight.Bold, // Make the title bold
                modifier = Modifier.padding(itemPadding) // Add padding around the title
            )
        }

        // Display the sub-content
        item {
            Text(
                text = stringResource(id = R.string.sub_content), // Load sub-content from resources
                fontSize = fontTextSize, // Use the predefined font size
                modifier = Modifier.padding(itemPadding) // Add padding around the sub-content
            )
        }

        // Display the main content
        item {
            Text(
                text = stringResource(id = R.string.main_content), // Load main content from resources
                fontSize = fontTextSize, // Use the predefined font size
                modifier = Modifier.padding(itemPadding), // Add padding around the main content
                textAlign = TextAlign.Justify // Justify the text for better readability
            )
        }
    }
}