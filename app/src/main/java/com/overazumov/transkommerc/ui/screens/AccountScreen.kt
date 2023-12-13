package com.overazumov.transkommerc.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.user.User
import com.overazumov.transkommerc.ui.screens.home.HomeViewModel
import com.overazumov.transkommerc.ui.screens.home.getPassenger
import com.overazumov.transkommerc.ui.theme.TranskommercTheme

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = HomeViewModel()
) {
    AccountCard(
        user = viewModel.user,
        modifier = modifier.padding(dimensionResource(R.dimen.medium_padding))
    )
}

@Composable
fun AccountCard(
    user: User,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserImage(user.imageRes)
            AccountInfo(user)
        }
    }
}

@Composable
private fun UserImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding(dimensionResource(R.dimen.medium_padding))
            .size(196.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun AccountInfo(
    user: User,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        InfoAttribute(
            attributeNameRes = R.string.user_name_attribute,
            attributeIcon = Icons.Default.Person,
            attributeData = user.name
        )
        Divider(
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.fillMaxWidth()
        )
        InfoAttribute(
            attributeNameRes = R.string.phone_number_attribute,
            attributeIcon = Icons.Default.Call,
            attributeData = user.phoneNumber.toString()
        )
    }
}

@Composable
private fun InfoAttribute(
    @StringRes attributeNameRes: Int,
    attributeIcon: ImageVector,
    attributeData: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            imageVector = attributeIcon,
            contentDescription = null,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.medium_padding))
                .size(dimensionResource(R.dimen.small_size))
        )
        Column {
            Text(stringResource(attributeNameRes))
            Divider(
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .padding(
                        top = 2.dp,
                        bottom = 2.dp,
                        end = dimensionResource(R.dimen.medium_padding)
                    )
                    .fillMaxWidth()
            )
            Text(attributeData)

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AccountScreenPreview() {
    TranskommercTheme {
        AccountScreen()
    }
}

@Preview
@Composable
private fun AccountCardPreview() {
    TranskommercTheme {
        AccountCard(getPassenger())
    }
}

@Preview(showBackground = true)
@Composable
private fun AccountInfoPreview() {
    TranskommercTheme {
        AccountInfo(getPassenger())
    }
}


@Preview(showBackground = true)
@Composable
private fun InfoAttributePreview() {
    TranskommercTheme {
        InfoAttribute(
            attributeNameRes = R.string.user_name_attribute,
            attributeIcon = Icons.Default.Person,
            attributeData = getPassenger().name
        )
    }
}