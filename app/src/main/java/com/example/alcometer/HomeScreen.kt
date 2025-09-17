package com.example.alcometer

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(myViewModel: HomeViewModel = viewModel()) {
    Column(modifier = Modifier.padding(6.dp)) {
        Title()
        WeightField(myViewModel = myViewModel)
        SexChoice(myViewModel = myViewModel)
        BottlesField(myViewModel = myViewModel)
        HoursField(myViewModel = myViewModel)
        CalculateButton(myViewModel = myViewModel)
        Text(text = myViewModel.result)
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.HomeScreenTitle),
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    )
}

@Composable
fun WeightField(myViewModel: HomeViewModel) {
    OutlinedTextField(
        value = myViewModel.weightInput,
        onValueChange = { myViewModel.weightInput = it },
        label = { Text(text = stringResource(R.string.WeightFieldLabel)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun SexChoice(myViewModel: HomeViewModel) {
    Column(Modifier.selectableGroup()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = myViewModel.male, onClick = { myViewModel.male = true })
            Text(text = "Male")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = !myViewModel.male, onClick = { myViewModel.male = false })
            Text(text = "Female")
        }
    }
}

@Composable
fun BottlesField(myViewModel: HomeViewModel) {
    OutlinedTextField(
        value = myViewModel.bottlesInput,
        onValueChange = { myViewModel.bottlesInput = it },
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = "Bottles drank") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        trailingIcon = {
            Row (modifier = Modifier.padding(12.dp)) {
                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.KeyboardArrowDownDescription),
                    Modifier
                        .size(32.dp)
                        .clickable { myViewModel.addBottleInput(false) })
                Icon(
                    Icons.Filled.KeyboardArrowUp,
                    contentDescription = stringResource(R.string.KeyboardArrowUpDescription),
                    Modifier
                        .size(32.dp)
                        .clickable { myViewModel.addBottleInput(true) })
            }
        },
    )
}

@Composable
fun HoursField(myViewModel: HomeViewModel) {
    OutlinedTextField(
        value = myViewModel.hoursInput,
        onValueChange = { myViewModel.hoursInput = it },
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = "Hours passed") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        trailingIcon = {
            Row (modifier = Modifier.padding(12.dp)) {
                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.KeyboardArrowDownDescription),
                    Modifier
                        .size(32.dp)
                        .clickable { myViewModel.addHourInput(false) })
                Icon(
                    Icons.Filled.KeyboardArrowUp,
                    contentDescription = stringResource(R.string.KeyboardArrowUpDescription),
                    Modifier
                        .size(32.dp)
                        .clickable { myViewModel.addHourInput(true) })
            }
        },
    )
}

@Composable
fun CalculateButton(myViewModel: HomeViewModel) {
    Button(
        onClick = {
            myViewModel.calculate()
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Calculate")
    }
}